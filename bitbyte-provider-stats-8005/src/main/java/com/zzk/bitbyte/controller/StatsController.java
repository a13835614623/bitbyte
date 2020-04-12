package com.zzk.bitbyte.controller;

import com.zzk.bitbyte.po.query.*;
import com.zzk.bitbyte.service.*;
import com.zzk.bitbyte.util.ResponseState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 博客数据统计
 * @Author: zzk
 * @Date: 2020-02-03 20:14
 */
@RestController
@RequestMapping("/stats")
public class StatsController {
    public static final String QUERY_SUCCESS="查询成功！";
    
    @Autowired
    ArticleStatsService articleStatsService;

    @Autowired
    UserStatsService userStatsService;

    @Autowired
    AccessStatsService accessStatsService;

    @Autowired
    ActionTopListStatsService actionTopListStatsService;

    @Autowired
    UserStatsExtendService userStatsExtendService;
    @RequestMapping("/article/get")
    public ResponseState article(@RequestBody ArticleStatsQueryVo queryVo) throws Exception {
        return ResponseState.success(QUERY_SUCCESS).setData(articleStatsService.getArticleStatsListByQueryVo(queryVo));
    }

    @RequestMapping("/user/get")
    public ResponseState user(@RequestBody UserStatsQueryVo queryVo) throws Exception {
        return ResponseState.success(QUERY_SUCCESS).setData(userStatsService.getUserStatsListByQueryVo(queryVo));
    }

    @RequestMapping("/access/get")
    public ResponseState access(@RequestBody AccessStatsQueryVo queryVo) throws Exception {
        return ResponseState.success(QUERY_SUCCESS).setData(accessStatsService.getAccessStatsListByQueryVo(queryVo));
    }

    @RequestMapping("/toplist/fans")
    public ResponseState topFansList(@RequestBody FansTopListStatsQueryVo queryVo) throws Exception {
        return ResponseState.success(QUERY_SUCCESS).setData(actionTopListStatsService.getFansNumTopUserList(queryVo));
    }

    @RequestMapping("/toplist/read")
    public ResponseState topReadList(@RequestBody ActionTopListStatsQueryVo queryVo) throws Exception {
        return ResponseState.success(QUERY_SUCCESS).setData(actionTopListStatsService.getReadNumTopArticleList(queryVo));
    }
    @RequestMapping("/toplist/like")
    public ResponseState topLikeList(@RequestBody(required = false) ActionTopListStatsQueryVo queryVo) throws Exception {
        return ResponseState.success(QUERY_SUCCESS).setData(actionTopListStatsService.getLikeNumTopArticleList(queryVo));
    }

    @RequestMapping("/toplist/comment")
    public ResponseState topCommentList(@RequestBody(required = false) ActionTopListStatsQueryVo queryVo) throws Exception {
        return ResponseState.success(QUERY_SUCCESS).setData(actionTopListStatsService.getCommentNumTopArticleList(queryVo));
    }

    @RequestMapping("/toplist/article")
    public ResponseState actionList(@RequestBody  ActionTopListStatsQueryVo queryVo) throws Exception {
        return ResponseState.success(QUERY_SUCCESS).setData(actionTopListStatsService.getActionNumTopArticleList(queryVo));
    }

    @RequestMapping("/user/fans")
    public ResponseState fans(@RequestBody UserFansStatsQueryVo queryVo) throws Exception {
        return ResponseState.success(QUERY_SUCCESS).setData(userStatsExtendService.getFansStatsListByQueryVo(queryVo));
    }

    @RequestMapping("/user/article")
    public ResponseState article(@RequestBody UserArticlesStatsQueryVo queryVo) throws Exception {
        return ResponseState.success(QUERY_SUCCESS).setData(userStatsExtendService.getUserArticleStatsByQueryVo(queryVo));
    }
}
