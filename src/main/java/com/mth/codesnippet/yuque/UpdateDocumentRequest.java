package com.mth.codesnippet.yuque;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

/**
 * @author 木土禾
 * Created on 2022/11/14 11:41:37
 */
public class UpdateDocumentRequest {

    private String title;

    private String slug;

    private String body;

    @JsonProperty("_force_asl")
    private Integer forceAsl;

    public String getTitle() {
        return title;
    }

    public UpdateDocumentRequest setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getSlug() {
        return slug;
    }

    public UpdateDocumentRequest setSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public String getBody() {
        return body;
    }

    public UpdateDocumentRequest setBody(String body) {
        this.body = body;
        return this;
    }

    public Integer getForceAsl() {
        return forceAsl;
    }

    public UpdateDocumentRequest setForceAsl(Integer forceAsl) {
        this.forceAsl = forceAsl;
        return this;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("title", title)
                .add("slug", slug)
                .add("body", body)
                .add("forceAsl", forceAsl)
                .toString();
    }
}
