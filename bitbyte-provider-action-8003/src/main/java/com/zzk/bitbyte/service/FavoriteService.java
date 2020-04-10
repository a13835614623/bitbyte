package com.zzk.bitbyte.service;

import com.zzk.bitbyte.po.Favorite;
import com.zzk.bitbyte.po.FavoriteExtend;
import com.zzk.bitbyte.po.FavoriteGroup;

import java.util.List;

/**
 * @Author: zzk
 * @Date: 2020-04-09 10:18
 */
public interface FavoriteService {

    /**
     * 添加收藏
     * @param articleId 文章ID
     * @param groupId  组ID
     * @return
     */
    Favorite addFavorite(String articleId,String groupId) throws Exception;

    /**
     * 添加收藏分类
     * @param groupName 组名
     * @param userId 用户ID
     * @return
     */
    FavoriteGroup addFavoriteGroup(String groupName, String userId) throws Exception;

    /**
     * 删除收藏
     * @param favoriteId
     */
    void deleteFavorite(String favoriteId) throws Exception;

    /**
     * 删除收藏分组
     * @param groupId
     */
    void deleteFavoriteGroup(String groupId) throws Exception;

    /**
     * 根据用户ID查询分组
     * @param userId
     * @return
     */
    List<FavoriteGroup> findFavoriteGroupListByUserId(String userId) throws Exception;

    /**
     * 根据组ID查询收藏列表
     * @param groupId
     * @return
     */
    List<FavoriteExtend> findFavoriteListByGroupId(String groupId) throws Exception;

    /**
     * 获取收藏情况
     * @param articleId 文章ID
     * @param userId 用户ID
     */
    Favorite findFavoriteByArticleIdAndUserId(String articleId, String userId) throws Exception;
}
