package com.zzk.bitbyte.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 审核提交成功
 * @Author: zzk
 * @Date: 2020-02-21 20:21
 */
public interface AuditCommitSuccessChannel {
    /**
     * 审核结束
     */
    String AUDIT_COMMIT_SUCCESS_OUTPUT = "audit_commit_success_output";
    String AUDIT_COMMIT_SUCCESS_INPUT = "audit_commit_success_input";

    @Input(AUDIT_COMMIT_SUCCESS_INPUT)
    SubscribableChannel auditCommitSuccessInput();

    @Output(AUDIT_COMMIT_SUCCESS_OUTPUT)
    MessageChannel auditCommitSuccessOutput();
}
