package com.zzk.bitbyte.service.impl;

import com.zzk.bitbyte.mapper.FavoriteExtendMapper;
import com.zzk.bitbyte.mapper.FavoriteGroupMapper;
import com.zzk.bitbyte.mapper.FavoriteMapper;
import com.zzk.bitbyte.po.*;
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
        Util.validateStr(articleId,"文章ID");
        Util.validateStr(groupId,"分组ID");
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
        Util.validateStr(userId,"用户ID");
        Util.validateStr(groupName,"分组名称");
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
        Util.validateStr(favoriteId,"收藏ID");
        favoriteMapper.deleteByPrimaryKey(favoriteId);
    }

    /**
     * 删除收藏分组
     *
     * @param groupId
     */
    @Override
    public void deleteFavoriteGroup(String groupId) throws Exception {
        Util.validateStr(groupId,"分组ID");
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
        Util.validateStr(userId,"用户ID");
        FavoriteGroupExample example = new FavoriteGroupExample();
        example.createCriteria().andFavoriteUserEqualTo(userId);
        return favoriteGroupMapper.selectByExample(example);
    }

    @Override
    public long findFavoriteGroupListCountByUserId(String userId) throws Exception {
        Util.validateStr(userId,"用户ID");
        FavoriteGroupExample example = new FavoriteGroupExample();
        example.createCriteria().andFavoriteUserEqualTo(userId);
        return favoriteGroupMapper.countByExample(example);
    }

    /**
     * 根据组ID查询收藏列表
     * @param groupId
     * @return
     */
    @Override
    public List<FavoriteExtend> findFavoriteList(String groupId,Integer start,Integer count) throws Exception {
        Util.validateStr(groupId,"分组ID" );
        Util.validateObj(start,"开始索引" );
        Util.validateObj(count,"个数");
        return favoriteExtendMapper.findFavoriteList(groupId,start, count);
    }
    public long findFavoriteListCount(String groupId) throws Exception {
        Util.validateStr(groupId,"分组ID" );
        return favoriteExtendMapper.findFavoriteListCount(groupId);
    }


    @Override
    public Favorite findFavoriteByArticleIdAndUserId(String articleId, String userId) throws Exception {
        Util.validateStr(userId,"用户ID" );
        Util.validateStr(articleId,"分组ID");
        return favoriteExtendMapper.findFavoriteByArticleIdAndUserId(articleId, userId);
    }
}
