package com.zzk.bitbyte.util;

/**
 * 角色常量
 * @Author: zzk
 * @Date: 2020-04-04 21:51
 */
public enum Roles {
    AUDITOR("50707e69-5073-4d39-b157-6b6f5f30886b","AUDITOR","博客审核员"),
    ADMIN("f4f6ec38-d958-41a7-9475-218aa72ac6f7","ADMIN","博客审核员"),
    USER("f8ebe91e-7451-4963-a6aa-e84223a0a11a","USER","博客审核员");

    /**
     * roleId
     */
    private String roleId;
    /**
     * 角色表达式
     */
    private String roleStr;
    /**
     * 角色描述
     */
    private String roleDesc;

    Roles(String roleId, String roleStr, String roleDesc) {
        this.roleId = roleId;
        this.roleStr = roleStr;
        this.roleDesc = roleDesc;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleStr() {
        return roleStr;
    }

    public void setRoleStr(String roleStr) {
        this.roleStr = roleStr;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
