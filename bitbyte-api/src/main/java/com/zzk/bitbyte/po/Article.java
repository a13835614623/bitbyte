package com.zzk.bitbyte.po;

import com.zzk.bitbyte.validation.ArticleCommitGroup;
import com.zzk.bitbyte.validation.ArticleTempGroup;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable{

    private String articleId;

    @Size(min = 3, max = 30, message = "文章长度必须为3-30个字符!", groups = {ArticleTempGroup.class, ArticleCommitGroup.class})
    private String articleTitle;

    private Integer articleState;

    private String articleUser;

    private Long articleRead;

    private Date articlePublishTime;

    @NotBlank(message = "文章标签不能为空!", groups = {ArticleCommitGroup.class})
    private String articleTags;


    @NotNull(message = "文章分区不能为空!", groups = {ArticleCommitGroup.class})
    private Integer articlePart;

    @NotBlank(message = "文章摘要不能为空!", groups = {ArticleCommitGroup.class})
    private String articleSummary;

    private Date createat;

    private Date updateat;

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary;
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleState(Integer articleState) {
        this.articleState = articleState;
    }

    public Integer getArticleState() {
        return articleState;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId == null ? null : articleId.trim();
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public String getArticleUser() {
        return articleUser;
    }

    public void setArticleUser(String articleUser) {
        this.articleUser = articleUser == null ? null : articleUser.trim();
    }

    public Long getArticleRead() {
        return articleRead;
    }

    public void setArticleRead(Long articleRead) {
        this.articleRead = articleRead;
    }

    public Date getArticlePublishTime() {
        return articlePublishTime;
    }

    public void setArticlePublishTime(Date articlePublishTime) {
        this.articlePublishTime = articlePublishTime;
    }

    public String getArticleTags() {
        return articleTags;
    }

    public void setArticleTags(String articleTags) {
        this.articleTags = articleTags == null ? null : articleTags.trim();
    }

    public Integer getArticlePart() {
        return articlePart;
    }

    public void setArticlePart(Integer articlePart) {
        this.articlePart = articlePart;
    }

    public Date getCreateat() {
        return createat;
    }

    public void setCreateat(Date createat) {
        this.createat = createat;
    }

    public Date getUpdateat() {
        return updateat;
    }

    public void setUpdateat(Date updateat) {
        this.updateat = updateat;
    }

}