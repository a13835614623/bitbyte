package com.zzk.bitbyte.service;

import com.zzk.bitbyte.po.ArticleWithBLOBs;
import com.zzk.bitbyte.po.query.ArticleQueryVo;
import com.zzk.bitbyte.util.ResponseState;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "BITBYTE-ARTICLE")
public interface ArticleService {

    /**
     * 根据文章ID获取文章全部信息(包括内容)
     *
     * @param articleId 文章id
     */
    @RequestMapping(value = "/get/{articleId}", method = RequestMethod.GET)
    public ResponseState get(@PathVariable("articleId") String articleId);

    /**
     * 查询文章及其作者信息列表
     *
     * @param articleQueryVo 文章查询对象
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseState list(@RequestBody ArticleQueryVo articleQueryVo);

    /**
     * 查询文章列表数量
     *
     * @param articleQueryVo 文章查询对象
     */
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public ResponseState count(@RequestBody ArticleQueryVo articleQueryVo);

    /**
     * 根据用户id查询关注用户的最新发布的五篇文章
     *
     * @param userId 用户id
     */
    @RequestMapping(value = "/latest", method = RequestMethod.GET)
    public ResponseState latest(@RequestParam("userId") String userId);

    /**
     * 获取文章点赞数量
     *
     * @param articleId 文章id
     */
    @RequestMapping(value = "/like/count", method = RequestMethod.GET)
    public ResponseState likeCount(@RequestParam("articleId") String articleId);

    /**
     * 发布文章
     * @param articleId  文章id
     */
    @RequestMapping("/publish")
    public ResponseState publish(@RequestParam("articleId") String articleId);

    /**
     * 暂存文章
     *
     * @param userId  用户id
     * @param article 文章
     */
    @RequestMapping("/temp")
    public ResponseState temp(@RequestParam("userId") String userId,
                              @RequestBody ArticleWithBLOBs article);

    /**
     * 删除文章
     *
     * @param userId       用户id
     * @param articleId    文章id
     * @param articleTitle 文章标题
     */
    @RequestMapping("/delete")
    public ResponseState delete(@RequestParam("userId") String userId,
                                @RequestParam("articleId") String articleId,
                                @RequestParam("articleTitle") String articleTitle
    );

    /**
     * 点赞
     *
     * @param userId    用户id
     * @param articleId 文章id
     */
    @RequestMapping("/like")
    public ResponseState like(@RequestParam("userId") String userId, @RequestParam("articleId") String articleId);

    /**
     * 取消点赞
     *
     * @param userId    用户id
     * @param articleId 文章id
     */
    @RequestMapping("/dislike")
    public ResponseState dislike(@RequestParam("userId") String userId,
                                 @RequestParam("articleId") String articleId);

    /**
     * 获取用户是否点赞了文章
     *
     * @param userId    用户id
     * @param articleId 文章id
     */
    @RequestMapping("/islike")
    public ResponseState islike(@RequestParam("userId") String userId,
                                @RequestParam("articleId") String articleId);

    /**
     * 增加文章阅读量
     *
     * @param articleId
     */
    @RequestMapping("/read/add")
    public ResponseState addRead(@RequestParam("articleId") String articleId);
}
