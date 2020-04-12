package com.zzk.bitbyte.po.query;

import lombok.Data;

import java.util.Date;

/**
 * 用户粉丝数查询对象
 * @Author: zzk
 * @Date: 2020-04-12 14:11
 */
@Data
public class UserFansStatsQueryVo extends StatsQueryVo {

    private String userId;

    private Date subTimeStart;

    private Date subTimeEnd;
}
