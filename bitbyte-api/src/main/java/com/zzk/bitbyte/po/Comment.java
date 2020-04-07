package com.zzk.bitbyte.po;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class Comment extends CommentKey {
    @NotBlank(message = "评论用户不能为空")
    private String commentUser;

    @NotBlank(message = "评论用户名不能为空")
    private String commentUserName;

    @NotBlank(message = "评论内容不能为空")
    private String commentContent;

    private Date commentTime;

    private Date createat;

    private Date updateat;

    private String commentUserPic;

    public String getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(String commentUser) {
        this.commentUser = commentUser == null ? null : commentUser.trim();
    }

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName == null ? null : commentUserName.trim();
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
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

    public String getCommentUserPic() {
        return commentUserPic;
    }

    public void setCommentUserPic(String commentUserPic) {
        this.commentUserPic = commentUserPic == null ? null : commentUserPic.trim();
    }
}