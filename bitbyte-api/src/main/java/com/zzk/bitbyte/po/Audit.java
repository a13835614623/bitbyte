package com.zzk.bitbyte.po;

import java.util.Date;

public class Audit {
    private String auditId;

    private String auditArticle;

    private Integer auditState;

    private String auditReason;

    private String auditMore;

    private String auditUser;

    private Date auditTime;

    private Date createat;

    private Date updateat;

    public String getAuditId() {
        return auditId;
    }

    public void setAuditId(String auditId) {
        this.auditId = auditId == null ? null : auditId.trim();
    }

    public String getAuditArticle() {
        return auditArticle;
    }

    public void setAuditArticle(String auditArticle) {
        this.auditArticle = auditArticle == null ? null : auditArticle.trim();
    }

    public Integer getAuditState() {
        return auditState;
    }

    public void setAuditState(Integer auditState) {
        this.auditState = auditState;
    }

    public String getAuditReason() {
        return auditReason;
    }

    public void setAuditReason(String auditReason) {
        this.auditReason = auditReason == null ? null : auditReason.trim();
    }

    public String getAuditMore() {
        return auditMore;
    }

    public void setAuditMore(String auditMore) {
        this.auditMore = auditMore == null ? null : auditMore.trim();
    }

    public String getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(String auditUser) {
        this.auditUser = auditUser == null ? null : auditUser.trim();
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
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