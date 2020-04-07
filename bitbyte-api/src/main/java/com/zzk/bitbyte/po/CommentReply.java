package com.zzk.bitbyte.po;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class CommentReply extends CommentReplyKey {
    @NotBlank(message = "回复用户昵称不能为空")
    private String fromUserName;

    @NotBlank(message = "回复用户ID不能为空")
    private String fromUserId;

    @NotBlank(message = "评论用户昵称不能为空")
    private String toUserName;

    @NotBlank(message = "评论用户ID不能为空")
    private String toUserId;

    @NotBlank(message = "回复内容不能为空")
    private String replyContent;

    private Date replyTime;

    private Date createat;

    private Date updateat;

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName == null ? null : fromUserName.trim();
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId == null ? null : fromUserId.trim();
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName == null ? null : toUserName.trim();
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId == null ? null : toUserId.trim();
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
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