package com.zzk.bitbyte.po.query;

import lombok.Data;

/**
 * 数据统计查询包装类
 * @Author: zzk
 * @Date: 2020-02-04 15:18
 */
@Data
public abstract class StatsQueryVo extends QueryVo {
    /**
     * 日期格式化字符串,%Y-%m-%d
     */
    private String dateFormat="%Y-%m-%d";//格式字符串
}
