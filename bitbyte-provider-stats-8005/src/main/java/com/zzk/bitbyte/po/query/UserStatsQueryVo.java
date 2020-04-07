package com.zzk.bitbyte.po.query;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zzk.bitbyte.po.Article;
import com.zzk.bitbyte.po.User;
import lombok.Data;

import java.util.Date;

/**
 * 用户统计查询包装类
 * @Author: zzk
 * @Date: 2020-02-04 11:35
 */
@Data
public class UserStatsQueryVo extends StatsQueryVo {

    private User user;

    private Date regTimeStart;
    private Date regTimeEnd;

    //是否以性别分组
    @JsonProperty("isGroupBySex")
    private boolean isGroupBySex;

    // 是否以注册时间分组
    @JsonProperty("isGroupByRegTime")
    private boolean isGroupByRegTime;
}
