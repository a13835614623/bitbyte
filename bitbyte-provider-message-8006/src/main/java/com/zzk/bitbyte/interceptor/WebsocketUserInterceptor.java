
package com.zzk.bitbyte.interceptor;

import com.zzk.bitbyte.po.UserPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
public class WebsocketUserInterceptor implements ChannelInterceptor {

    @Autowired
    private WebsocketManager websocketManager;

    @SuppressWarnings("rawtypes")
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
        assert accessor != null;
        if (StompCommand.CONNECT.equals(accessor.getCommand())) {
            UserPrincipal userPrincipal = new UserPrincipal(Objects.requireNonNull(accessor.getNativeHeader("UserId")).get(0));
            accessor.setUser(userPrincipal);
            websocketManager.pushOnlineUser(userPrincipal);
            log.info("----------------客户端[{}]连接成功---------------", userPrincipal.getName());
        } else if (StompCommand.DISCONNECT.equals(accessor.getCommand())) {
            //点击断开连接，这里会执行两次，第二次执行的时候，message.getHeaders.size()=5,第一次是6。直接关闭浏览器，只会执行一次，size是5。
            UserPrincipal principal = (UserPrincipal) message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER);
            //  如果同时发生两个连接，只有都断开才能叫做不在线
            assert principal != null;
            websocketManager.removeOnlineUser(principal.getUserId());
            log.info("----------------客户端[{}]断开连接---------------", principal.getName());
        }
        return message;
    }
}