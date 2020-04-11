package com.zzk.bitbyte.controller;

import com.zzk.bitbyte.po.Favorite;
import com.zzk.bitbyte.po.FavoriteGroup;
import com.zzk.bitbyte.service.FavoriteService;
import com.zzk.bitbyte.util.ResponseState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zzk
 * @Date: 2020-04-09 10:11
 */
@RequestMapping("/action/favorite")
@RestController
public class FavoriteController {

    @Autowired
    FavoriteService favoriteService;

    /**
     * 添加收藏
     */
    @RequestMapping("/add")
    public ResponseState add(@RequestParam("articleId") String articleId,
                             @RequestParam("groupId") String groupId) throws Exception {
        long count = favoriteService.findFavoriteListCount(groupId);
        if (count>999){
            return ResponseState.error("单个收藏夹不能包含超过1000篇文章!");
        }
        Favorite favorite = favoriteService.addFavorite(articleId,groupId);
        return ResponseState.success("添加收藏成功!").setData(favorite);
    }

    /**
     * 删除收藏
     */
    @RequestMapping("/delete")
    public ResponseState delete(@RequestParam("favoriteId") String favoriteId) throws Exception {
        favoriteService.deleteFavorite(favoriteId);
        return ResponseState.success("删除收藏成功!");
    }
    
    /**
     * 添加收藏分组
     */
    @RequestMapping("/group/add")
    public ResponseState addGroup(@RequestParam("groupName") String groupName,
                                  @RequestParam("userId") String userId) throws Exception {
        if (favoriteService.findFavoriteGroupListCountByUserId(userId)>10){
            return ResponseState.error("收藏夹个数不能超过10个");
        }
        FavoriteGroup favoriteGroup= favoriteService.addFavoriteGroup(groupName,userId);
        return ResponseState.success("添加收藏分组成功!").setData(favoriteGroup);
    }

    /**
     * 删除收藏分组
     */
    @RequestMapping("/group/delete")
    public ResponseState deleteGroup(@RequestParam("groupId") String groupId) throws Exception {
        favoriteService.deleteFavoriteGroup(groupId);
        return ResponseState.success("删除收藏分组成功!");
    }

    /**
     * 根据用户ID查询收藏夹分组
     * @param userId
     * @return
     */
    @RequestMapping("/group/get")
    public ResponseState findGroupByUserId(@RequestParam("userId") String userId) throws Exception {
        return ResponseState.success("查询成功!")
                .setData(favoriteService.findFavoriteGroupListByUserId(userId));
    }

    /**
     * 根据组ID查询收藏夹文章
     * @param groupId
     * @return
     */
    @RequestMapping("/get")
    public ResponseState findFavoritesByGroupId(@RequestParam("groupId") String groupId,
                                                @RequestParam("start") Integer start,
                                                @RequestParam("count") Integer count) throws Exception {
        return ResponseState.success("查询成功!")
                .setData(favoriteService.findFavoriteList(groupId,start, count))
                .setMore(favoriteService.findFavoriteListCount(groupId));
    }

    /**
     * 根据用户ID和文章ID查询收藏情况
     * @param articleId
     * @param userId
     * @return
     */
    @RequestMapping("/info")
    public ResponseState findFavoriteByArticleIdAndUserId(@RequestParam("articleId") String articleId,
                                               @RequestParam("userId") String userId) throws Exception {
        return ResponseState.success("查询成功!")
                .setData(favoriteService.findFavoriteByArticleIdAndUserId(articleId, userId));
    }
}
