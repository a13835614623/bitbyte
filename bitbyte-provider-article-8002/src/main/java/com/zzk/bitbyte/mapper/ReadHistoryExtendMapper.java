package com.zzk.bitbyte.mapper;

import com.zzk.bitbyte.po.ReadHistory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReadHistoryExtendMapper {
    /**
     * 根据用户ID获取用户记录
     * @param userId
     * @return
     */
    List<ReadHistory> findReadHistoryByUserId(String userId);

    /**
     * 根据用户ID获取阅读过的所有文章
     * @param userId
     * @return
     */
    List<String> findReadArticleByUserId(String userId);

    /**
     * 根据文章ID列表获取阅读过的用户ID
     * @param articleIdList
     * @return
     */
    List<String> findUserIdListByArticleId(List<String> articleIdList);

}