package com.mth.codesnippet.yuque;

/**
 * @author 木土禾
 * Created on 2022/11/14 22:28:07
 */
public class DocumentResponse {

    private Document data;

    public Document getData() {
        return data;
    }

    public DocumentResponse setData(Document data) {
        this.data = data;
        return this;
    }

    public static class Document {
        private Integer id;

        private String slug;

        private String title;

        private String body;

        public Integer getId() {
            return id;
        }

        public Document setId(Integer id) {
            this.id = id;
            return this;
        }

        public String getSlug() {
            return slug;
        }

        public Document setSlug(String slug) {
            this.slug = slug;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public Document setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getBody() {
            return body;
        }

        public Document setBody(String body) {
            this.body = body;
            return this;
        }
    }

}
