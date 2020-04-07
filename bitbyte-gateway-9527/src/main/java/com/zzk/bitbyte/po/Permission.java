package com.zzk.bitbyte.po;

import java.util.Date;

public class Permission {
    private String permId;

    private String permStr;

    private String permDesc;

    private Date createat;

    private Date updateat;

    public String getPermId() {
        return permId;
    }

    public void setPermId(String permId) {
        this.permId = permId == null ? null : permId.trim();
    }

    public String getPermStr() {
        return permStr;
    }

    public void setPermStr(String permStr) {
        this.permStr = permStr == null ? null : permStr.trim();
    }

    public String getPermDesc() {
        return permDesc;
    }

    public void setPermDesc(String permDesc) {
        this.permDesc = permDesc == null ? null : permDesc.trim();
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