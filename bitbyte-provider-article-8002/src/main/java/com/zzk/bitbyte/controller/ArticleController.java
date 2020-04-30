package com.zzk.bitbyte.controller;

import com.zzk.bitbyte.message.MessageProducer;
import com.zzk.bitbyte.po.ArticleWithBLOBs;
import com.zzk.bitbyte.po.Record;
import com.zzk.bitbyte.po.extend.ArticleExtend;
import com.zzk.bitbyte.po.query.ArticleQueryVo;
import com.zzk.bitbyte.service.ArticleService;
import com.zzk.bitbyte.util.ResponseState;
import com.zzk.bitbyte.util.Util;
import com.zzk.bitbyte.validation.ArticleCommitGroup;
import com.zzk.bitbyte.validation.ArticleTempGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 处理文章相关请求
 *
 * @className: ArticleController
 * @author: zzk
 * @date: 2019-03-23 13:01
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Qualifier("articleServiceImpl")
    @Autowired
    private ArticleService articleService;

    @Autowired
    private MessageProducer messageProducer;


    /**
     * 添加记录
     *
     * @param recordContent 记录内容
     * @param recordUser    记录用户id
     */
    public void addRecord(String recordContent, String recordUser) {
        Record record = new Record();
        record.setRecordContent(recordContent);
        record.setRecordUser(recordUser);
        messageProducer.sendRecord(record);
    }

    public void sendCommitAudit(String articleId){
        messageProducer.sendCommitAudit(articleId);
    }

    /**
     * 获取推荐文章
     * @return
     */
    @RequestMapping("/recommend/get")
    public ResponseState getRecommendArticlesByUserId(@RequestParam(value = "userId",required = false,defaultValue = "")
                                                                  String userId) throws Exception {
        return ResponseState.success("获取推荐文章成功!").setData(articleService.findRecommendArticleList(userId));
    }

    /**
     * 根据文章ID获取文章全部信息(包括内容)
     *
     * @param articleId 文章id
     */
    @RequestMapping(value = "/get/{articleId}")
    public ResponseState getArticleWithContentByArticleId(@PathVariable("articleId") String articleId)
            throws Exception {
        ResponseState state = new ResponseState();
        state.setData(articleService.findArticleAndContentById(articleId));
        state.setStatus(ResponseState.STATUS_SUCCESS);
        state.setMessage("获取文章成功!");
        return state;
    }

    /**
     * 根据用户id获取用户文章列表
     *
     * @param userId 用户id
     */
    @RequestMapping(value = "/user/get/{userId}")
    public ResponseState getArticlesByUserId(@PathVariable("userId") String userId) {
        ResponseState state = new ResponseState();
        state.setData(articleService.findArticlesByUserId(userId));
        state.setStatus(ResponseState.STATUS_SUCCESS);
        state.setMessage("获取文章列表成功!");
        return state;
    }


    /**
     * 查询文章及其作者信息列表
     *
     * @param articleQueryVo 文章查询对象
     */
    @RequestMapping(value = "/list")
    public ResponseState getArticlesByQueryVo(@RequestBody ArticleQueryVo articleQueryVo)
            throws Exception {
        ResponseState state = new ResponseState();
        List<ArticleExtend> articles = articleService.findArticleAndAuthorByQueryVo(articleQueryVo);
        state.setStatus(ResponseState.STATUS_SUCCESS);
        state.setData(articles);
        state.setMore(articleService.findArticleCountByQueryVo(articleQueryVo));
        state.setMessage("文章查询成功!");
        return state;
    }

    /**
     * 查询文章列表数量
     *
     * @param articleQueryVo 文章查询对象
     */
    @RequestMapping(value = "/count")
    public ResponseState getArticleCountByQueryVo(@RequestBody ArticleQueryVo articleQueryVo)
            throws Exception {
        ResponseState state = new ResponseState();
        Integer count = articleService.findArticleCountByQueryVo(articleQueryVo);
        state.setStatus(ResponseState.STATUS_SUCCESS);
        state.setData(count);
        state.setMessage("文章数量查询成功!");
        return state;
    }

    /**
     * 根据用户id查询关注用户的最新发布的五篇文章
     *
     * @param userId 用户id
     */
    @RequestMapping(value = "/latest")
    public ResponseState getUserLatestArticles(@RequestParam String userId)
            throws Exception {
        ResponseState state = new ResponseState();
        List<ArticleExtend> articles = articleService.findLatestSubArticleAndAuthorByUserId(userId);
        state.setStatus(ResponseState.STATUS_SUCCESS);
        state.setData(articles);
        state.setMessage("最新关注文章查询成功!");
        return state;
    }

    /**
     * 获取文章点赞数量
     *
     * @param articleId 文章id
     */
    @RequestMapping(value = "/like/count")
    public ResponseState getArticleLikeCount(@RequestParam("articleId") String articleId)
            throws Exception {
        ResponseState state = new ResponseState();
        state.setStatus(ResponseState.STATUS_SUCCESS);
        state.setData(articleService.findArticleLikeCount(articleId));
        state.setMessage("获取用户点赞数量成功!");
        return state;
    }

    /**
     * 发布文章
     *
     * @return
     */
    @RequestMapping("/publish")
    public ResponseState publishArticle(@RequestParam("articleId") String articleId) throws Exception {
        articleService.publishArticle(articleId);
        return ResponseState.success("发布成功!");
    }

    /**
     * 提交审核
     *
     * @param userId  用户id
     * @param article 文章
     */
    @RequestMapping("/commit")
    public ResponseState commitAudit(@RequestParam("userId") String userId,
                                     @RequestBody @Validated(value = ArticleCommitGroup.class) ArticleWithBLOBs article,
                                     BindingResult bindingResult
    ) throws Exception {
        Util.handleBindingError(bindingResult);
        ResponseState state = new ResponseState();
        article.setArticleUser(userId);
        //暂存
        String articleId = articleService.tempArticle(article);
        // 提交审核
        sendCommitAudit(articleId);
        state.setData(articleId);
        state.setMessage("文章投递成功!");
        state.setStatus(ResponseState.STATUS_SUCCESS);
        addRecord("投递文章《" + article.getArticleTitle() + "》", userId);
        return state;
    }

    /**
     * 暂存文章
     *
     * @param userId  用户id
     * @param article 文章
     */
    @RequestMapping("/temp")
    public ResponseState tempArticle(@RequestParam("userId") String userId,
                                     @RequestBody @Validated(value = ArticleTempGroup.class) ArticleWithBLOBs article,
                                     BindingResult bindingResult
    ) throws Exception {
        Util.handleBindingError(bindingResult);
        ResponseState state = new ResponseState();
        article.setArticleUser(userId);
        String articleId = articleService.tempArticle(article);
        state.setMessage("文章暂存成功!");
        state.setData(articleId);
        state.setStatus(ResponseState.STATUS_SUCCESS);
        addRecord("暂存文章《" + article.getArticleTitle() + "》", userId);
        return state;
    }

    /**
     * 删除文章
     *
     * @param userId       用户id
     * @param articleId    文章id
     * @param articleTitle 文章标题
     */
    @RequestMapping("/delete")
    public ResponseState deleteArticle(@RequestParam("userId") String userId,
                                       @RequestParam("articleId") String articleId,
                                       @RequestParam("articleTitle") String articleTitle
    ) throws Exception {
        ResponseState state = new ResponseState();
        articleService.deleteArticle(userId, articleId);
        state.setMessage("文章删除成功!");
        state.setStatus(ResponseState.STATUS_SUCCESS);
        addRecord("删除文章《" + articleTitle + "》", userId);
        return state;
    }

    /**
     * 点赞
     *
     * @param userId    用户id
     * @param articleId 文章id
     */
    @RequestMapping("/like")
    public ResponseState likerticle(@RequestParam("userId") String userId, @RequestParam("articleId") String articleId) throws Exception {
        articleService.likeArticle(userId, articleId);
        ResponseState state = new ResponseState();
        state.setStatus(ResponseState.STATUS_SUCCESS);
        state.setMessage("文章点赞成功!");
        state.setData(articleService.isLikeArticle(userId, articleId));
        return state;
    }

    /**
     * 取消点赞
     *
     * @param userId    用户id
     * @param articleId 文章id
     */
    @RequestMapping("/dislike")
    public ResponseState dislikeArticle(@RequestParam("userId") String userId,
                                        @RequestParam("articleId") String articleId) throws Exception {
        articleService.dislikeArticle(userId, articleId);
        ResponseState state = new ResponseState();
        state.setStatus(ResponseState.STATUS_SUCCESS);
        state.setMessage("文章取消点赞成功!");
        state.setData(articleService.isLikeArticle(userId, articleId));
        return state;
    }

    /**
     * 获取用户是否点赞了文章
     *
     * @param userId    用户id
     * @param articleId 文章id
     */
    @RequestMapping("/islike")
    public ResponseState isLikeArticle(@RequestParam("userId") String userId,
                                          @RequestParam("articleId") String articleId) throws Exception {
        ResponseState state = new ResponseState();
        state.setStatus(ResponseState.STATUS_SUCCESS);
        state.setMessage("获取文章点赞情况成功!");
        state.setData(articleService.isLikeArticle(userId, articleId));
        return state;
    }

    /**
     * 增加文章阅读量
     *
     * @param articleId
     */
    @RequestMapping("/read/add")
    public ResponseState addArticleReadCount(@RequestParam("articleId") String articleId,
                                             @RequestParam("userId") String userId) throws Exception {
        articleService.addArticleReadCount(articleId,userId);
        ResponseState state = new ResponseState();
        state.setStatus(ResponseState.STATUS_SUCCESS);
        state.setMessage("文章阅读+1成功!");
        return state;
    }

    /**
     * 获取用户文章阅读总数
     */
    @RequestMapping("/user/read/count")
    public ResponseState getArticleReadCountByUserId(@RequestParam("userId") String userId) throws Exception {
        return ResponseState.success("获取用户文章阅读数成功!").setData(articleService.findArticleReadCountByUserId(userId));
    }
}
