package com.zzk.bitbyte.po.query;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * 访问数据统计查询对象
 * @Author: zzk
 * @Date: 2020-02-05 10:05
 */
@Data
public class AccessStatsQueryVo extends StatsQueryVo{

    /**
     * 是否按照访问时间分组
     */
    @JsonProperty("isGroupByAccessTime")
    private boolean isGroupByAccessTime;
    /**
     * 是否按照访问类型分组
     */
    @JsonProperty("isGroupByAccessType")
    private boolean isGroupByAccessType;
    /**
     * 是否按照访问值分组
     */
    @JsonProperty("isGroupByAccessValue")
    private boolean isGroupByAccessValue;

    private Date accessTimeStart;

    private Date accessTimeEnd;
}
