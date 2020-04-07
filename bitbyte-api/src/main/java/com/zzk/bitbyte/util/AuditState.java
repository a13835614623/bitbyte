package com.zzk.bitbyte.util;

/**
 * @Author: zzk
 * @Date: 2020-02-19 15:02
 */
public enum AuditState {
    AUDIT_SUCCESS("审核通过",24),
    AUDIT_REFUSE("审核拒绝",25),
    AUDIT_INIT("未审核",26);
    /**
     * 状态描述
     */
    private String desc;
    /**
     * value表中对应的id
     */
    private int valueId;

    private AuditState(String desc, int valueId) {
        this.desc=desc;
        this.valueId=valueId;
    }

    public String getDesc() {
        return desc;
    }

    public int getValueId() {
        return valueId;
    }
}
