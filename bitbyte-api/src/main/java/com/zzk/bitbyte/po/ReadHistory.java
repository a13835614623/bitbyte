package com.zzk.bitbyte.po;

import java.util.Date;

public class ReadHistory {
    private String readId;

    private String readArticle;

    private Date readTime;

    private String readUser;

    private Date createat;

    private Date updateat;

    public String getReadId() {
        return readId;
    }

    public void setReadId(String readId) {
        this.readId = readId == null ? null : readId.trim();
    }

    public String getReadArticle() {
        return readArticle;
    }

    public void setReadArticle(String readArticle) {
        this.readArticle = readArticle == null ? null : readArticle.trim();
    }

    public Date getReadTime() {
        return readTime;
    }

    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }

    public String getReadUser() {
        return readUser;
    }

    public void setReadUser(String readUser) {
        this.readUser = readUser == null ? null : readUser.trim();
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