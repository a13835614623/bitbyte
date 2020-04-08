package com.zzk.bitbyte.util;

/**
 * 用户状态
 * @Author: zzk
 * @Date: 2020-04-04 21:25
 */
public enum UserState {
    LOCKED("已锁定",31),
    DELETED("已删除",32),
    BANNED("已封禁",33),
    NORMAL("正常",34);
    /**
     * 状态描述
     */
    private String desc;
    /**
     * value表中对应的id
     */
    private int valueId;

    private UserState(String desc, int valueId) {
        this.desc=desc;
        this.valueId=valueId;
    }

    public String getDesc() {
        return desc;
    }

    public int getValueId() {
        return valueId;
    }

    public boolean isEquals(int valueId){
        return getValueId()==valueId;
    }
}
