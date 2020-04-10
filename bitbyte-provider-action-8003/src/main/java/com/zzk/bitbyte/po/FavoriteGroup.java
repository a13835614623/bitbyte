package com.zzk.bitbyte.po;

import java.util.Date;

public class FavoriteGroup {
    private String favoriteGroupId;

    private String favoriteUser;

    private String favoriteGroupName;

    private Date favoriteCreateTime;

    private Date createat;

    private Date updateat;

    public String getFavoriteGroupId() {
        return favoriteGroupId;
    }

    public void setFavoriteGroupId(String favoriteGroupId) {
        this.favoriteGroupId = favoriteGroupId == null ? null : favoriteGroupId.trim();
    }

    public String getFavoriteUser() {
        return favoriteUser;
    }

    public void setFavoriteUser(String favoriteUser) {
        this.favoriteUser = favoriteUser == null ? null : favoriteUser.trim();
    }

    public String getFavoriteGroupName() {
        return favoriteGroupName;
    }

    public void setFavoriteGroupName(String favoriteGroupName) {
        this.favoriteGroupName = favoriteGroupName == null ? null : favoriteGroupName.trim();
    }

    public Date getFavoriteCreateTime() {
        return favoriteCreateTime;
    }

    public void setFavoriteCreateTime(Date favoriteCreateTime) {
        this.favoriteCreateTime = favoriteCreateTime;
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