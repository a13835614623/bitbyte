package com.zzk.bitbyte.po;

import java.util.Date;

public class RolePermission {
    private String rolePermId;

    private String roleId;

    private String permId;

    private Date createat;

    private Date updateat;

    public String getRolePermId() {
        return rolePermId;
    }

    public void setRolePermId(String rolePermId) {
        this.rolePermId = rolePermId == null ? null : rolePermId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getPermId() {
        return permId;
    }

    public void setPermId(String permId) {
        this.permId = permId == null ? null : permId.trim();
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