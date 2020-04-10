package com.zzk.bitbyte.mapper;

import com.zzk.bitbyte.po.Favorite;
import com.zzk.bitbyte.po.FavoriteExtend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zzk
 * @Date: 2020-04-09 10:42
 */
@Mapper
public interface FavoriteExtendMapper {
    /**
     * 根据组ID查询收藏列表
     * @param groupId
     * @return
     */
    List<FavoriteExtend> findFavoriteListByGroupId(String groupId);

    /**
     * 根据文章ID和用户ID获取收藏信息
     * @param articleId
     * @param userId
     * @return
     */
    Favorite findFavoriteByArticleIdAndUserId(@Param("articleId") String articleId,
                                              @Param("userId") String userId);
}
