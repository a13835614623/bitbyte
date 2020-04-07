package com.zzk.bitbyte.po;

public class ArticleLikeKey {
    private String likeArticle;

    private String likeUser;

    public String getLikeArticle() {
        return likeArticle;
    }

    public void setLikeArticle(String likeArticle) {
        this.likeArticle = likeArticle == null ? null : likeArticle.trim();
    }

    public String getLikeUser() {
        return likeUser;
    }

    public void setLikeUser(String likeUser) {
        this.likeUser = likeUser == null ? null : likeUser.trim();
    }
}