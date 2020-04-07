package com.zzk.bitbyte.mapper;

import com.zzk.bitbyte.po.ArticleStats;
import com.zzk.bitbyte.po.UserStats;
import com.zzk.bitbyte.po.query.ArticleStatsQueryVo;
import com.zzk.bitbyte.po.query.UserStatsQueryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zzk
 * @Date: 2020-02-03 20:24
 */
@Mapper
public interface UserStatsMapper {

    List<UserStats> getUserStatsListByQueryVo(UserStatsQueryVo queryVo);
}
