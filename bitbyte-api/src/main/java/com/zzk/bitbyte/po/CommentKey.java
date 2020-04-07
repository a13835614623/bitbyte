package com.zzk.bitbyte.po;

public class CommentKey {
    private Long commentFloor;

    private String commentArticle;

    public Long getCommentFloor() {
        return commentFloor;
    }

    public void setCommentFloor(Long commentFloor) {
        this.commentFloor = commentFloor;
    }

    public String getCommentArticle() {
        return commentArticle;
    }

    public void setCommentArticle(String commentArticle) {
        this.commentArticle = commentArticle == null ? null : commentArticle.trim();
    }
}