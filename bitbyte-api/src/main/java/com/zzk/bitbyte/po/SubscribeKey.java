package com.zzk.bitbyte.po;

public class SubscribeKey {
    private String subUserChild;

    private String subUserParent;

    public String getSubUserChild() {
        return subUserChild;
    }

    public void setSubUserChild(String subUserChild) {
        this.subUserChild = subUserChild == null ? null : subUserChild.trim();
    }

    public String getSubUserParent() {
        return subUserParent;
    }

    public void setSubUserParent(String subUserParent) {
        this.subUserParent = subUserParent == null ? null : subUserParent.trim();
    }
}