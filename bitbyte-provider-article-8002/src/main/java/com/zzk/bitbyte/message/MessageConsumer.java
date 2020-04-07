package com.zzk.bitbyte.message;

import com.zzk.bitbyte.channel.AuditCancelChannel;
import com.zzk.bitbyte.channel.AuditCommitSuccessChannel;
import com.zzk.bitbyte.channel.AuditEndChannel;
import com.zzk.bitbyte.po.Audit;
import com.zzk.bitbyte.service.ArticleService;
import com.zzk.bitbyte.util.ArticleState;
import com.zzk.bitbyte.util.AuditState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

/**
 * 监听消息
 *
 * @Author: zzk
 * @Date: 2020-02-19 14:36
 */
@EnableBinding({AuditEndChannel.class,AuditCommitSuccessChannel.class, AuditCancelChannel.class})
@Slf4j
public class MessageConsumer extends AbstractMessageConsumer {

    @Qualifier("articleServiceImpl")
    @Autowired
    private ArticleService articleService;

    /**
     * 审核结束
     * @param message
     * @throws Exception
     */
    @StreamListener(AuditEndChannel.AUDIT_END_INPUT)
    void auditEndInput(Message<Audit> message) throws Exception {
        log.info("[审核结束]消息接收成功!");
        Audit audit = message.getPayload();
        int state = audit.getAuditState();
        String articleId = audit.getAuditArticle();
        // 审核成功,发布
        if (state== AuditState.AUDIT_SUCCESS.getValueId()){
            articleService.publishArticle(audit.getAuditArticle());
        }else if(state == AuditState.AUDIT_REFUSE.getValueId()){
            // 审核拒绝，设置文章状态
            articleService.updateArticleState(articleId,ArticleState.REFUSE);
        }
        log.info("[审核结束]消息消费成功!");
    }

    /**
     * 审核提交成功
     */
    @StreamListener(AuditCommitSuccessChannel.AUDIT_COMMIT_SUCCESS_INPUT)
    void auditCommitSuccessInput(Message<String> message) throws Exception {
        log.info("[审核提交成功]消息接收成功!");
        String articleId = message.getPayload();
        // 设置文章状态为[审核中]
        articleService.updateArticleState(articleId,ArticleState.AUDITING);
        log.info("[审核提交成功]消息消费成功!");
    }

    /**
     * 审核撤销
     */
    @StreamListener(AuditCancelChannel.AUDIT_CANCEL_INPUT)
    void auditCancel(Message<String> message) throws Exception {
        log.info("[审核撤销]消息接收成功!");
        String articleId = message.getPayload();
        // 设置文章状态为[审核中]
        articleService.updateArticleState(articleId,ArticleState.AUDITING);
        log.info("[审核撤销]消息消费成功!");
    }
}
