package com.mth.codesnippet.yuque;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellij.openapi.project.Project;
import com.mth.codesnippet.constants.YuQueConstants;
import com.mth.codesnippet.utils.NotifyUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * @author 木土禾
 * Created on 2022/11/14 22:39:26
 */
public class YuQueInstance {

    private final YuQueConfigDTO yuQueConfigDTO;

    private final HttpClient httpClient;
    
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    {
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    private final Project project;

    public YuQueInstance(YuQueConfigDTO yuQueConfigDTO, Project project) {
        this.yuQueConfigDTO = yuQueConfigDTO;
        this.project = project;
        this.httpClient = HttpClient.newBuilder().build();
    }

    public void upsertDoc(String md) throws IOException, InterruptedException {
        String slug = LocalDate.now().toString();
        DocumentResponse.Document documentResponse = queryBySlug(slug);
        if (Objects.isNull(documentResponse)) {
            DocumentResponse.Document doc = createDoc(new CreateDocumentRequest()
                    .setSlug(slug)
                    .setTitle(slug)
                    .setBody(md));
            moveToc(new TocRequest().setAction(YuQueConstants.DEFAULT_TOC_ACTION).setDocIds(List.of(doc.getId())));
        } else {
            String updateContent = documentResponse.getBody() + "\n\n" + md;
            updateDoc(new UpdateDocumentRequest()
                    .setSlug(slug)
                    .setTitle(documentResponse.getTitle())
                    .setBody(updateContent)
                    .setForceAsl(YuQueConstants.FORCE_ASL), documentResponse.getId());
        }
    }

    public DocumentResponse.Document createDoc(CreateDocumentRequest createDocumentRequest) throws IOException, InterruptedException {
        String path = String.format(YuQueConstants.CREATE_DOC, yuQueConfigDTO.getRepo());
        String url = YuQueConstants.BASE_URL + path;
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("User-Agent", YuQueConstants.CODE_SNIPPET)
                .header(YuQueConstants.TOKEN_HEADER, yuQueConfigDTO.getToken())
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(OBJECT_MAPPER.writeValueAsString(createDocumentRequest)))
                .build();
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        notifyIfRequestFailed(response);
        return OBJECT_MAPPER.readValue(response.body(), DocumentResponse.class).getData();
    }

    private void notifyIfRequestFailed(HttpResponse<String> response) {
        if (!YuQueConstants.SUCCESS.equals(response.statusCode())) {
            NotifyUtils.sendErrorMsg(project, response.body());
            throw new IllegalStateException();
        }
    }

    public DocumentResponse.Document queryBySlug(String slug) throws IOException, InterruptedException {
        String path = String.format(YuQueConstants.QUERY_DOC, yuQueConfigDTO.getRepo(), slug);
        String url = YuQueConstants.BASE_URL + path;
        HttpRequest queryBySlug = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("User-Agent", YuQueConstants.CODE_SNIPPET)
                .header(YuQueConstants.TOKEN_HEADER, yuQueConfigDTO.getToken())
                .GET()
                .build();
        HttpResponse<String> queryResp = httpClient.send(queryBySlug, HttpResponse.BodyHandlers.ofString());
        if (YuQueConstants.NOT_FOUND.equals(queryResp.statusCode())) {
            return null;
        }
        notifyIfRequestFailed(queryResp);
        return OBJECT_MAPPER.readValue(queryResp.body(), DocumentResponse.class).getData();
    }

    public void updateDoc(UpdateDocumentRequest updateDocumentRequest, Integer docId) throws IOException, InterruptedException {
        String path = String.format(YuQueConstants.UPDATE_DOC, yuQueConfigDTO.getRepo(), docId);
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(YuQueConstants.BASE_URL + path))
                .header("User-Agent", YuQueConstants.CODE_SNIPPET)
                .header(YuQueConstants.TOKEN_HEADER, yuQueConfigDTO.getToken())
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(OBJECT_MAPPER.writeValueAsString(updateDocumentRequest)))
                .build();
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        notifyIfRequestFailed(response);
    }

    public void moveToc(TocRequest tocRequest) throws IOException, InterruptedException {
        String path = String.format(YuQueConstants.TOC, yuQueConfigDTO.getRepo());
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(YuQueConstants.BASE_URL + path))
                .header("User-Agent", YuQueConstants.CODE_SNIPPET)
                .header(YuQueConstants.TOKEN_HEADER, yuQueConfigDTO.getToken())
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(OBJECT_MAPPER.writeValueAsString(tocRequest)))
                .build();
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        notifyIfRequestFailed(response);
    }
}
