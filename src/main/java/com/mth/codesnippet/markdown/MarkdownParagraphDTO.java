package com.mth.codesnippet.markdown;

import com.google.common.base.MoreObjects;

/**
 * @author 木土禾
 * Created on 2022/11/13 15:23:19
 */
public class MarkdownParagraphDTO {

    private String note;

    private String codeType;

    private String codeSnippet;

    public String getNote() {
        return note;
    }

    public MarkdownParagraphDTO setNote(String note) {
        this.note = note;
        return this;
    }

    public String getCodeType() {
        return codeType;
    }

    public MarkdownParagraphDTO setCodeType(String codeType) {
        this.codeType = codeType;
        return this;
    }

    public String getCodeSnippet() {
        return codeSnippet;
    }

    public MarkdownParagraphDTO setCodeSnippet(String codeSnippet) {
        this.codeSnippet = codeSnippet;
        return this;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("note", note)
                .add("codeType", codeType)
                .add("codeSnippet", codeSnippet)
                .toString();
    }
}
