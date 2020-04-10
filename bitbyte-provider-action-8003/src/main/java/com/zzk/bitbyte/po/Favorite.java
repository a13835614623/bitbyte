package com.zzk.bitbyte.po;

import java.util.Date;

public class Favorite {
    private String favoriteId;

    private String favoriteArticle;

    private Date favoriteTime;

    private String favoriteGroup;

    private Date createat;

    private Date updateat;

    public String getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(String favoriteId) {
        this.favoriteId = favoriteId == null ? null : favoriteId.trim();
    }

    public String getFavoriteArticle() {
        return favoriteArticle;
    }

    public void setFavoriteArticle(String favoriteArticle) {
        this.favoriteArticle = favoriteArticle == null ? null : favoriteArticle.trim();
    }

    public Date getFavoriteTime() {
        return favoriteTime;
    }

    public void setFavoriteTime(Date favoriteTime) {
        this.favoriteTime = favoriteTime;
    }

    public String getFavoriteGroup() {
        return favoriteGroup;
    }

    public void setFavoriteGroup(String favoriteGroup) {
        this.favoriteGroup = favoriteGroup == null ? null : favoriteGroup.trim();
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