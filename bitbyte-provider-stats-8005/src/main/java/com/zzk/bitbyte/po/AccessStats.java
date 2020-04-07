package com.zzk.bitbyte.po;

import lombok.Data;

/**
 * 访问量数据
 * @Author: zzk
 * @Date: 2020-02-05 09:58
 */
@Data
public class AccessStats extends Stats {
    /**
     * 访问时间
     */
    private String time;
    /**
     * 访问类型
     */
    private Integer type;
    /**
     * 访问值,不同类型对应不同的值
     */
    private Integer value;
    /**
     * 访问人数
     */
    private Integer peopleNum;
}
