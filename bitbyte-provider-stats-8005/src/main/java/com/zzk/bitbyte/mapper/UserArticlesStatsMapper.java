package com.zzk.bitbyte.mapper;

import com.zzk.bitbyte.po.UserArticlesStats;
import com.zzk.bitbyte.po.query.UserArticlesStatsQueryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zzk
 * @Date: 2020-04-12 14:26
 */
@Mapper
public interface UserArticlesStatsMapper {
    /**
     * 获取粉丝数stats根据查询对象
     * @param queryVo
     * @return
     */
    List<UserArticlesStats> getUserArticleStatsByQueryVo(UserArticlesStatsQueryVo queryVo);

}
