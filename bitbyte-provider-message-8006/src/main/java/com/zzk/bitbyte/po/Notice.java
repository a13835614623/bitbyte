package com.zzk.bitbyte.po;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 系统公告
 */
public class Notice {
    private String noticeId;

    @NotBlank(message = "公告内容不能为空!")
    private String noticeContent;

    private Date noticeTime;

    @NotBlank(message = "公告标题不能为空!")
    private String noticeTitle;

    @NotBlank(message = "公告topic不能为空!")
    private String noticeTopic;

    @NotBlank(message = "公告发布者不能为空!")
    private String noticePublisher;

    private Date createat;

    private Date updateat;

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId == null ? null : noticeId.trim();
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }

    public Date getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle == null ? null : noticeTitle.trim();
    }

    public String getNoticeTopic() {
        return noticeTopic;
    }

    public void setNoticeTopic(String noticeTopic) {
        this.noticeTopic = noticeTopic == null ? null : noticeTopic.trim();
    }

    public String getNoticePublisher() {
        return noticePublisher;
    }

    public void setNoticePublisher(String noticePublisher) {
        this.noticePublisher = noticePublisher == null ? null : noticePublisher.trim();
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