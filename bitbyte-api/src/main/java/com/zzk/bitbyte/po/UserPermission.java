package com.zzk.bitbyte.po;

import java.util.Date;

public class UserPermission {
    private String userPermId;

    private String userId;

    private String pernId;

    private Date createat;

    private Date updateat;

    public String getUserPermId() {
        return userPermId;
    }

    public void setUserPermId(String userPermId) {
        this.userPermId = userPermId == null ? null : userPermId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPernId() {
        return pernId;
    }

    public void setPernId(String pernId) {
        this.pernId = pernId == null ? null : pernId.trim();
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