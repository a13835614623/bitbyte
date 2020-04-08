package com.zzk.bitbyte.util;

/**
 * 文章审核状态
 * @Author: zzk
 * @Date: 2020-04-04 15:08
 */
public enum ArticleState{
    PASS("审核通过",24),
    REFUSE("审核拒绝",25),
    CREATED("已创建",27),
    PUBLISHED("已发布",28),
    AUDITING("审核中",29),
    DELETED("已删除",32);
    /**
     * 状态描述
     */
    private String desc;
    /**
     * value表中对应的id
     */
    private int valueId;

    private ArticleState(String desc, int valueId) {
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
