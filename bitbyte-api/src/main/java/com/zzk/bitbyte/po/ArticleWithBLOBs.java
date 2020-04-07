package com.zzk.bitbyte.po;

import com.zzk.bitbyte.validation.ArticleCommitGroup;

import javax.validation.constraints.NotBlank;

public class ArticleWithBLOBs extends Article {
    @NotBlank(message = "文章内容不能为空!", groups = {ArticleCommitGroup.class})
    private String articleContent;

    private String articleMdContent;

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }

    public String getArticleMdContent() {
        return articleMdContent;
    }

    public void setArticleMdContent(String articleMdContent) {
        this.articleMdContent = articleMdContent == null ? null : articleMdContent.trim();
    }
}