package com.zzk.bitbyte.util;

/**
 * @Author: zzk
 * @Date: 2020-02-20 09:16
 */
public interface WebSocketChannel {


    /**
     * 审核结束的消息
     */
    String AUDIT_END="/audit/end";

    /**
     * 系统公告
     */
    String SYSTEM_NOTICE="/system/notice";

    /**
     * 系统消息
     */
    String SYSTEM_MESSAGE="/system/msg";

    /**
     * 用户私信
     */
    String USER_CHAT = "/user/chat";
}
