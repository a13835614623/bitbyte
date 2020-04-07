package com.zzk.bitbyte.controller;

import com.zzk.bitbyte.service.SubscribeService;
import com.zzk.bitbyte.util.ResponseState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 处理用户关注相关请求
 *
 * @author zzk
 */
@RestController
@RequestMapping("/action/subscribe")
public class SubscribeController {

    @Qualifier("subscribeServiceImpl")
    @Autowired
    private SubscribeService subscribeService;

    /**
     * 关注用户
     * @param userId       关注发起者
     * @param subscriberId 被关注着
     * @throws Exception
     */
    @RequestMapping(value = "/add")
    public ResponseState subscribe(@RequestParam("userId") String userId,
                                   @RequestParam("subscriberId") String subscriberId) throws Exception {
        subscribeService.subscribe(userId, subscriberId);
        ResponseState state = new ResponseState();
        state.setStatus(ResponseState.STATUS_SUCCESS);
        state.setMessage("关注成功!");
        return state;
    }

    /**
     * 取消关注
     * @param userId       取消关注发起者
     * @param subscriberId 被关注者
     * @throws Exception
     */
    @RequestMapping(value = "/remove")
    public ResponseState removeSubscribe(@RequestParam("userId") String userId,
                                         @RequestParam("subscriberId") String subscriberId) throws Exception {
        subscribeService.removeSubscribe(userId, subscriberId);
        ResponseState state = new ResponseState();
        state.setStatus(ResponseState.STATUS_SUCCESS);
        state.setMessage("取消关注成功!");
        return state;
    }

    /**
     * 获取是否关注
     *
     * @param userId       请求发起用户ID
     * @param subscriberId 判断用户ID
     * @throws Exception
     */
    @RequestMapping(value = "/isSubscribe")
    public ResponseState isSubscribe(@RequestParam("userId") String userId,
                                     @RequestParam("subscriberId") String subscriberId) throws Exception {
        ResponseState state = new ResponseState();
        state.setStatus(ResponseState.STATUS_SUCCESS);
        state.setData(subscribeService.isSubscribe(userId, subscriberId));
        state.setMessage("获取关注情况成功!");
        return state;
    }
}
