package com.zzk.bitbyte.po;

public class CommentReplyKey {
    private Long replyCommentFloor;

    private String replyCommentArticle;

    private Long replyFloor;

    public Long getReplyCommentFloor() {
        return replyCommentFloor;
    }

    public void setReplyCommentFloor(Long replyCommentFloor) {
        this.replyCommentFloor = replyCommentFloor;
    }

    public String getReplyCommentArticle() {
        return replyCommentArticle;
    }

    public void setReplyCommentArticle(String replyCommentArticle) {
        this.replyCommentArticle = replyCommentArticle == null ? null : replyCommentArticle.trim();
    }

    public Long getReplyFloor() {
        return replyFloor;
    }

    public void setReplyFloor(Long replyFloor) {
        this.replyFloor = replyFloor;
    }
}