package com.zzk.bitbyte.service;

import com.zzk.bitbyte.po.UserStats;
import com.zzk.bitbyte.po.query.UserStatsQueryVo;

import java.util.List;

/**
 * 用户数据统计服务
 * @Author: zzk
 * @Date: 2020-02-04 14:43
 */
public interface UserStatsService {
    /**
     * 根据查询对象查询count
     * @param queryVo
     * @return
     */
    List<UserStats> getUserStatsListByQueryVo(UserStatsQueryVo queryVo) throws Exception;

}
