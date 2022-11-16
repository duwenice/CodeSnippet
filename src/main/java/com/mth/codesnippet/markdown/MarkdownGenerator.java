package com.mth.codesnippet.markdown;

/**
 * @author 木土禾
 * Created on 2022/11/13 16:02:44
 */
public class MarkdownGenerator {

    public static String generateMd(MarkdownParagraphDTO markdownParagraphDTO) throws Exception {
        String markdownPattern = "#### %s\n```%s\n%s\n```";
        return String.format(markdownPattern, markdownParagraphDTO.getNote(), markdownParagraphDTO.getCodeType(), markdownParagraphDTO.getCodeSnippet());
    }
}
