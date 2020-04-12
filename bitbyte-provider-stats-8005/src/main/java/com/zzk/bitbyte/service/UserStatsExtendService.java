package com.zzk.bitbyte.service;

import com.zzk.bitbyte.po.UserArticlesStats;
import com.zzk.bitbyte.po.UserFansStats;
import com.zzk.bitbyte.po.query.UserArticlesStatsQueryVo;
import com.zzk.bitbyte.po.query.UserFansStatsQueryVo;

import java.util.List;

/**
 * @Author: zzk
 * @Date: 2020-04-12 15:23
 */
public interface UserStatsExtendService {
    /**
     * 获取粉丝数stats根据查询对象
     * @param queryVo
     * @return
     */
    List<UserArticlesStats> getUserArticleStatsByQueryVo(UserArticlesStatsQueryVo queryVo) throws Exception;

    /**
     * 获取粉丝数stats根据查询对象
     * @param queryVo
     * @return
     */
    List<UserFansStats> getFansStatsListByQueryVo(UserFansStatsQueryVo queryVo) throws Exception;
}
