package com.zzk.bitbyte.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 撤销审核
 * @Author: zzk
 * @Date: 2020-04-04 18:45
 */
public interface AuditCancelChannel {
    /**
     * 撤销审核
     */
    String AUDIT_CANCEL_OUTPUT = "audit_cancel_output"; // 输出通道名称
    String AUDIT_CANCEL_INPUT = "audit_cancel_input"; // 输入通道名称

    @Input(AUDIT_CANCEL_INPUT)
    SubscribableChannel auditCancelInput();

    @Output(AUDIT_CANCEL_OUTPUT)
    MessageChannel auditCancelOutput();
}
