package com.zzk.bitbyte.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 审核结束
 * @Author: zzk
 * @Date: 2020-02-21 20:21
 */
public interface AuditEndChannel {
    /**
     * 审核结束
     */
    String AUDIT_END_OUTPUT = "audit_end_output";
    String AUDIT_END_INPUT = "audit_end_input";

    @Input(AUDIT_END_INPUT)
    SubscribableChannel auditEndInput();

    @Output(AUDIT_END_OUTPUT)
    MessageChannel auditEndOutput();
}
