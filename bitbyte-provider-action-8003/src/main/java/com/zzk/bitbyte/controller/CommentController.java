package com.zzk.bitbyte.controller;

import com.zzk.bitbyte.po.Comment;
import com.zzk.bitbyte.po.CommentReply;
import com.zzk.bitbyte.service.CommentService;
import com.zzk.bitbyte.util.ResponseState;
import com.zzk.bitbyte.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 处理文章评论相关请求
 *
 * @author zzk
 */
@RestController
@RequestMapping("/action/comment")
public class CommentController {

    @Qualifier("commentServiceImpl")
    @Autowired
    private CommentService commentService;

    /**
     * 添加评论
     * @param comment 评论
     */
    @RequestMapping(value = "/add")
    public ResponseState comment(@Valid @RequestBody Comment comment, BindingResult bindingResult) throws Exception {
        Util.handleBindingError(bindingResult);
        ResponseState state = new ResponseState();
        state.setStatus(ResponseState.STATUS_SUCCESS);
        commentService.addComment(comment);
        state.setMessage("评论成功");
        return state;
    }

    /**
     * 回复评论
     * @param commentReply 评论回复
     */
    @RequestMapping(value = "/reply")
    public ResponseState commentReply(@Valid @RequestBody CommentReply commentReply,
                                      BindingResult bindingResult)
            throws Exception {
        Util.handleBindingError(bindingResult);
        ResponseState state = new ResponseState();
        state.setStatus(ResponseState.STATUS_SUCCESS);
        commentService.addCommentReply(commentReply);
        state.setMessage("评论回复成功");
        return state;
    }

    /**
     * 根据文章id获取评论
     * @param articleId 文章id
     */
    @RequestMapping(value = "/get")
    public ResponseState getCommentsByArticleId(@RequestParam("articleId") String articleId)
            throws Exception {
        ResponseState state = new ResponseState();
        state.setStatus(ResponseState.STATUS_SUCCESS);
        state.setData(commentService.findArticleCommentsById(articleId));
        state.setMessage("获取文章评论成功");
        return state;
    }

    /**
     * 根据用户ID获取发布文章的评论总数
     * @param userId 用户id
     */
    @RequestMapping(value = "/user/count")
    public ResponseState getUserCommentCountByUserId(@RequestParam("userId") String userId)
            throws Exception {
        ResponseState state = new ResponseState();
        state.setStatus(ResponseState.STATUS_SUCCESS);
        state.setData(commentService.findUserArticleCommentCountByUserId(userId));
        state.setMessage("获取用户文章评论总数成功");
        return state;
    }
}
