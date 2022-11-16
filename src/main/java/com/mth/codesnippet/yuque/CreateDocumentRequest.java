package com.mth.codesnippet.yuque;

import com.google.common.base.MoreObjects;

/**
 * @author 木土禾
 * Created on 2022/11/14 11:38:58
 */
public class CreateDocumentRequest {

    private String title;

    private String slug;

    private String body;

    public String getTitle() {
        return title;
    }

    public CreateDocumentRequest setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getSlug() {
        return slug;
    }

    public CreateDocumentRequest setSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public String getBody() {
        return body;
    }

    public CreateDocumentRequest setBody(String body) {
        this.body = body;
        return this;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("title", title)
                .add("slug", slug)
                .add("body", body)
                .toString();
    }
}
