package com.zzk.bitbyte.service.impl;

import com.zzk.bitbyte.mapper.FavoriteExtendMapper;
import com.zzk.bitbyte.mapper.FavoriteGroupMapper;
import com.zzk.bitbyte.mapper.FavoriteMapper;
import com.zzk.bitbyte.po.Favorite;
import com.zzk.bitbyte.po.FavoriteExtend;
import com.zzk.bitbyte.po.FavoriteGroup;
import com.zzk.bitbyte.po.FavoriteGroupExample;
import com.zzk.bitbyte.service.FavoriteService;
import com.zzk.bitbyte.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author: zzk
 * @Date: 2020-04-09 10:31
 */
@Transactional
@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    FavoriteMapper favoriteMapper;

    @Autowired
    FavoriteGroupMapper favoriteGroupMapper;

    @Autowired
    FavoriteExtendMapper favoriteExtendMapper;

    /**
     * 添加收藏
     *
     * @param articleId 文章ID
     * @param groupId   组ID
     * @return
     */
    @Override
    public Favorite addFavorite(String articleId, String groupId) throws Exception {
        Util.validateStr("文章ID", articleId);
        Util.validateStr("分组ID",groupId);
        Favorite favorite = new Favorite();
        favorite.setFavoriteId(UUID.randomUUID().toString());
        favorite.setFavoriteArticle(articleId);
        favorite.setFavoriteGroup(groupId);
        Date now=new Date();
        favorite.setFavoriteTime(now);
        favorite.setCreateat(now);
        favorite.setUpdateat(now);
        favoriteMapper.insert(favorite);
        return favorite;
    }

    /**
     * 添加收藏分类
     *
     * @param groupName 组名
     * @param userId 文章ID
     * @return
     */
    @Override
    public FavoriteGroup addFavoriteGroup(String groupName, String userId) throws Exception {
        Util.validateStr("用户ID", userId);
        Util.validateStr("分组名称",groupName);
        FavoriteGroup favoriteGroup = new FavoriteGroup();
        favoriteGroup.setFavoriteGroupId(UUID.randomUUID().toString());
        favoriteGroup.setFavoriteGroupName(groupName);
        favoriteGroup.setFavoriteUser(userId);
        Date now=new Date();
        favoriteGroup.setFavoriteCreateTime(now);
        favoriteGroup.setCreateat(now);
        favoriteGroup.setUpdateat(now);
        favoriteGroupMapper.insert(favoriteGroup);
        return favoriteGroup;
    }

    /**
     * 删除收藏
     *
     * @param favoriteId
     */
    @Override
    public void deleteFavorite(String favoriteId) throws Exception {
        Util.validateStr("收藏ID", favoriteId);
        favoriteMapper.deleteByPrimaryKey(favoriteId);
    }

    /**
     * 删除收藏分组
     *
     * @param groupId
     */
    @Override
    public void deleteFavoriteGroup(String groupId) throws Exception {
        Util.validateStr("分组ID", groupId);
        favoriteGroupMapper.deleteByPrimaryKey(groupId);
    }

    /**
     * 根据用户ID查询分组
     *
     * @param userId
     * @return
     */
    @Override
    public List<FavoriteGroup> findFavoriteGroupListByUserId(String userId) throws Exception {
        Util.validateStr("用户ID", userId);
        FavoriteGroupExample example = new FavoriteGroupExample();
        example.createCriteria().andFavoriteUserEqualTo(userId);
        return favoriteGroupMapper.selectByExample(example);
    }

    /**
     * 根据组ID查询收藏列表
     * @param groupId
     * @return
     */
    @Override
    public List<FavoriteExtend> findFavoriteListByGroupId(String groupId) throws Exception {
        Util.validateStr("分组ID", groupId);
        return favoriteExtendMapper.findFavoriteListByGroupId(groupId);
    }

    @Override
    public Favorite findFavoriteByArticleIdAndUserId(String articleId, String userId) throws Exception {
        Util.validateStr("用户ID", userId);
        Util.validateStr("分组ID",articleId);
        return favoriteExtendMapper.findFavoriteByArticleIdAndUserId(articleId, userId);
    }
}
