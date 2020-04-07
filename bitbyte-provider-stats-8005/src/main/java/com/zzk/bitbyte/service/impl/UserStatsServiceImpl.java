package com.zzk.bitbyte.service.impl;

import com.zzk.bitbyte.mapper.UserStatsMapper;
import com.zzk.bitbyte.po.UserStats;
import com.zzk.bitbyte.po.query.UserStatsQueryVo;
import com.zzk.bitbyte.service.UserStatsService;
import com.zzk.bitbyte.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: zzk
 * @Date: 2020-02-04 17:08
 */
@Service
@Transactional
public class UserStatsServiceImpl implements UserStatsService {
    @Autowired
    private UserStatsMapper mapper;
    /**
     * 根据查询对象查询count
     *
     * @param queryVo
     * @return
     */
    @Override
    public List<UserStats> getUserStatsListByQueryVo(UserStatsQueryVo queryVo) throws Exception {
        Util.validateQueryVo(queryVo);
        return mapper.getUserStatsListByQueryVo(queryVo);
    }
}
