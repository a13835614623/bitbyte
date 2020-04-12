package com.zzk.bitbyte.service.impl;

import com.zzk.bitbyte.mapper.UserArticlesStatsMapper;
import com.zzk.bitbyte.mapper.UserFansStatsMapper;
import com.zzk.bitbyte.po.UserArticlesStats;
import com.zzk.bitbyte.po.UserFansStats;
import com.zzk.bitbyte.po.query.UserArticlesStatsQueryVo;
import com.zzk.bitbyte.po.query.UserFansStatsQueryVo;
import com.zzk.bitbyte.service.UserStatsExtendService;
import com.zzk.bitbyte.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: zzk
 * @Date: 2020-04-12 15:24
 */
@Service
@Transactional
public class UserStatsExtendServiceImpl implements UserStatsExtendService {

    @Autowired
    UserArticlesStatsMapper userArticlesStatsMapper;

    @Autowired
    UserFansStatsMapper userFansStatsMapper;

    /**
     * 获取粉丝数stats根据查询对象
     *
     * @param queryVo
     * @return
     */
    @Override
    public List<UserArticlesStats> getUserArticleStatsByQueryVo(UserArticlesStatsQueryVo queryVo) throws Exception {
        Util.validateObj(queryVo, "查询对象");
        if (queryVo.isGroupByComment() || queryVo.isGroupByFavorite() || queryVo.isGroupByRead() ||
                queryVo.isGroupByLike()) {
            return userArticlesStatsMapper.getUserArticleStatsByQueryVo(queryVo);
        }
        throw new Exception("非法的查询参数!");
    }

    /**
     * 获取粉丝数stats根据查询对象
     *
     * @param queryVo
     * @return
     */
    @Override
    public List<UserFansStats> getFansStatsListByQueryVo(UserFansStatsQueryVo queryVo) throws Exception {
        Util.validateObj(queryVo, "查询对象");
        return userFansStatsMapper.getFansStatsListByQueryVo(queryVo);
    }
}
