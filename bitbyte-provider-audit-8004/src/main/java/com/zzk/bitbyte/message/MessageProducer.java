package com.zzk.bitbyte.message;

import com.zzk.bitbyte.channel.AuditCancelChannel;
import com.zzk.bitbyte.channel.AuditCommitSuccessChannel;
import com.zzk.bitbyte.channel.AuditEndChannel;
import com.zzk.bitbyte.po.extend.AuditExtend;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;

/**
 * @Author: zzk
 * @Date: 2020-02-22 15:17
 */
@Slf4j
@EnableBinding({AuditEndChannel.class, AuditCommitSuccessChannel.class, AuditCancelChannel.class})
public class MessageProducer {
    @Resource(name = AuditEndChannel.AUDIT_END_OUTPUT)
    private MessageChannel auditEndOutput;

    @Resource(name = AuditCommitSuccessChannel.AUDIT_COMMIT_SUCCESS_OUTPUT)
    private MessageChannel auditCommitSuccessOutput;

    @Resource(name = AuditCancelChannel.AUDIT_CANCEL_OUTPUT)
    private MessageChannel auditCancelOutput;

    /**
     * 发送[审核结束]消息
     * @param audit
     */
    public void sendAuditEnd(AuditExtend audit) {
        auditEndOutput.send(MessageBuilder.withPayload(audit).build());
        log.info("[审核结束]消息发送成功!");
    }

    /**
     * 发送[审核提交成功]消息
     * @param articleId 文章ID
     */
    public void sendAuditCommitSuccess(String articleId){
        auditCommitSuccessOutput.send(MessageBuilder.withPayload(articleId).build());
        log.info("[审核提交成功]消息发送成功!");
    }

    /**
     * 发送[审核撤销]消息
     * @param articleId 文章ID
     */
    public void sendAuditCancel(String articleId){
        auditCancelOutput.send(MessageBuilder.withPayload(articleId).build());
        log.info("[审核撤销]消息发送成功!");
    }
}
