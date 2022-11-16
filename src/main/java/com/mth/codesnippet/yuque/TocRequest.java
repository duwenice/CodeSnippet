package com.mth.codesnippet.yuque;

import com.google.common.base.MoreObjects;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author 木土禾
 * Created on 2022/11/14 22:30:30
 */
public class TocRequest {

    private String action;

    @SerializedName("doc_ids")
    private List<Integer> docIds;

    public String getAction() {
        return action;
    }

    public TocRequest setAction(String action) {
        this.action = action;
        return this;
    }

    public List<Integer> getDocIds() {
        return docIds;
    }

    public TocRequest setDocIds(List<Integer> docIds) {
        this.docIds = docIds;
        return this;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("action", action)
                .add("docIds", docIds)
                .toString();
    }
}
