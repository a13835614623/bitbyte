package com.zzk.bitbyte.service.impl;

import com.zzk.bitbyte.mapper.SubscribeMapper;
import com.zzk.bitbyte.po.Subscribe;
import com.zzk.bitbyte.po.SubscribeKey;
import com.zzk.bitbyte.service.SubscribeService;
import com.zzk.bitbyte.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class SubscribeServiceImpl implements SubscribeService {

    @Autowired
    private SubscribeMapper subscribeMapper;

    public void preInvokeMethod(String userId, String subscriberId) throws Exception {
        if (Util.isEmpty(userId) || Util.isEmpty(subscriberId)) {
            throw new Exception("用户id和关注者ID不能为空!");
        }
    }


    @Override
    public void removeSubscribe(String userId, String subscriberId) throws Exception {
        preInvokeMethod(userId,subscriberId);
        SubscribeKey subscribeKey = new SubscribeKey();
        subscribeKey.setSubUserChild(userId);
        subscribeKey.setSubUserParent(subscriberId);
        subscribeMapper.deleteByPrimaryKey(subscribeKey);
    }

    @Override
    public void subscribe(String userId, String subscriberId) throws Exception {
        preInvokeMethod(userId,subscriberId);
        Subscribe subscribe = new Subscribe();
        Date now = new Date();
        subscribe.setCreateat(now);
        subscribe.setUpdateat(now);
        subscribe.setSubTime(now);
        subscribe.setSubUserChild(userId);
        subscribe.setSubUserParent(subscriberId);
        subscribeMapper.insert(subscribe);
    }

    @Override
    public boolean isSubscribe(String userId, String subscriberId) throws Exception {
        preInvokeMethod(userId,subscriberId);
        SubscribeKey subscribeKey = new SubscribeKey();
        subscribeKey.setSubUserChild(userId);
        subscribeKey.setSubUserParent(subscriberId);
        return subscribeMapper.selectByPrimaryKey(subscribeKey) != null;
    }
}
