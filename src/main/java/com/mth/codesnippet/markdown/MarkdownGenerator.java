package com.mth.codesnippet.markdown;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;

/**
 * @author 木土禾
 * Created on 2022/11/13 16:02:44
 */
public class MarkdownGenerator {

    public static String generateMd(MarkdownParagraphDTO markdownParagraphDTO) throws Exception {
        Configuration configuration = new Configuration(Configuration.getVersion());
        configuration.setClassForTemplateLoading(MarkdownGenerator.class, "/template");
        Template template = configuration.getTemplate("markdown.ftl", "utf-8");
        StringWriter writer = new StringWriter();
        HashMap<Object, Object> dataModel = new HashMap<>(8);
        dataModel.put("note", markdownParagraphDTO.getNote());
        dataModel.put("codeType", markdownParagraphDTO.getCodeType());
        dataModel.put("codeSnippet", markdownParagraphDTO.getCodeSnippet());
        template.process(dataModel, writer);
        return writer.toString();
    }
}
