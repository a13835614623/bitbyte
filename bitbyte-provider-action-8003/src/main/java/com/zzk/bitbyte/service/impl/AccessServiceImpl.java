package com.zzk.bitbyte.service.impl;

import com.zzk.bitbyte.mapper.AccessMapper;
import com.zzk.bitbyte.po.Access;
import com.zzk.bitbyte.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Date;

/**
 * @Author: zzk
 * @Date: 2020-02-05 11:52
 */
@Service
@Transactional
public class AccessServiceImpl implements AccessService {
    @Autowired
    AccessMapper accessMapper;
    /**
     * 添加访问对象
     *
     * @param access
     */
    @Override
    public void addAccess(Access access) {
        Assert.notNull(access,"访问对象不能为空!");
        Date now = new Date();
        access.setCreateat(now);
        access.setUpdateat(now);
        access.setAccessTime(now);
        accessMapper.insert(access);
    }
}
