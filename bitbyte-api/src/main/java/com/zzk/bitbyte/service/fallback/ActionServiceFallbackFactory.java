package com.zzk.bitbyte.service.fallback;

import com.zzk.bitbyte.po.ArticleWithBLOBs;
import com.zzk.bitbyte.po.Comment;
import com.zzk.bitbyte.po.CommentReply;
import com.zzk.bitbyte.po.query.ArticleQueryVo;
import com.zzk.bitbyte.service.ActionService;
import com.zzk.bitbyte.service.ArticleService;
import com.zzk.bitbyte.util.ResponseState;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ActionServiceFallbackFactory implements FallbackFactory<ActionService> {

    @Override
    public ActionService create(Throwable cause) {
        return new ActionService() {
            @Override
            public ResponseState comment(Comment comment) {
                return ResponseState.error("评论失败,请稍后重试!", Const.SERVICE_PROVIDER_ERROR);
            }

            @Override
            public ResponseState commentReply(CommentReply commentReply) {
                return ResponseState.error("评论回复失败,请稍后重试!", Const.SERVICE_PROVIDER_ERROR);
            }

            @Override
            public ResponseState getCommentsByArticleId(String articleId) {
                return ResponseState.error("获取文章评论失败,请稍后重试!", Const.SERVICE_PROVIDER_ERROR);
            }

            @Override
            public ResponseState subscribe(String userId, String subscriberId) {
                return ResponseState.error("关注失败,请稍后重试!", Const.SERVICE_PROVIDER_ERROR);
            }

            @Override
            public ResponseState removeSubscribe(String userId, String subscriberId) {
                return ResponseState.error("取消关注失败,请稍后重试!", Const.SERVICE_PROVIDER_ERROR);
            }

            @Override
            public ResponseState isSubscribe(String userId, String subscriberId) {
                return ResponseState.error("获取关注情况失败,请稍后重试!", Const.SERVICE_PROVIDER_ERROR);
            }
        };
    }
}
