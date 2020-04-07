package com.zzk.bitbyte.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 提交审核
 * @Author: zzk
 * @Date: 2020-02-19 14:07
 */
public interface AuditChannel {
    /**
     * 提交审核
     */
    String AUDIT_OUTPUT = "audit_output"; // 输出通道名称
    String AUDIT_INPUT = "audit_input"; // 输入通道名称

    @Input(AUDIT_INPUT)
    SubscribableChannel auditInput();

    @Output(AUDIT_OUTPUT)
    MessageChannel auditOutput();
}
