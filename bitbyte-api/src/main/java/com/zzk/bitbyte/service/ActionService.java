package com.zzk.bitbyte.service;

import com.zzk.bitbyte.po.Comment;
import com.zzk.bitbyte.po.CommentReply;
import com.zzk.bitbyte.service.fallback.ActionServiceFallbackFactory;
import com.zzk.bitbyte.util.ResponseState;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "BITBYTE-ACTION", fallbackFactory = ActionServiceFallbackFactory.class)
public interface ActionService {
    /**
     * 添加评论
     *
     * @param comment 评论
     */
    @RequestMapping(value = "/comment/add", method = RequestMethod.POST)
    public ResponseState comment(@RequestBody Comment comment);

    /**
     * 回复评论
     *
     * @param commentReply 评论回复
     */
    @RequestMapping(value = "/comment/reply", method = RequestMethod.POST)
    public ResponseState commentReply(@RequestBody CommentReply commentReply);

    /**
     * 根据文章id获取评论
     *
     * @param articleId 文章id
     */
    @RequestMapping(value = "/comment/get", method = RequestMethod.GET)
    public ResponseState getCommentsByArticleId(@RequestParam("articleId") String articleId);

    @RequestMapping(value = "/subscribe/add", method = RequestMethod.POST)
    public ResponseState subscribe(@RequestParam("userId") String userId,
                                   @RequestParam("subscriberId") String subscriberId);

    /**
     * 取消关注
     *
     * @param userId       取消关注发起者
     * @param subscriberId 被关注者
     */
    @RequestMapping(value = "/subscribe/remove", method = RequestMethod.POST)
    public ResponseState removeSubscribe(@RequestParam("userId") String userId,
                                         @RequestParam("subscriberId") String subscriberId);

    /**
     * 获取是否关注
     *
     * @param userId       请求发起用户ID
     * @param subscriberId 判断用户ID
     */
    @RequestMapping(value = "/subscribe/isSubscribe", method = RequestMethod.GET)
    public ResponseState isSubscribe(@RequestParam("userId") String userId,
                                     @RequestParam("subscriberId") String subscriberId);
}
