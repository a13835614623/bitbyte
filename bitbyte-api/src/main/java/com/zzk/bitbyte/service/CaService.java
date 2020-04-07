package com.zzk.bitbyte.service;

import com.zzk.bitbyte.service.fallback.CaServiceFallbackFactory;
import com.zzk.bitbyte.util.ResponseState;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: zzk
 * @Date: 2020-02-09 14:30
 */
@FeignClient(value = "BITBYTE-CA",fallbackFactory = CaServiceFallbackFactory.class)
public interface CaService {
    /**
     * 登录,登录成功后颁发token
     * @param username 用户名
     * @param password 密码
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseState login(@RequestParam("username") String username,
                               @RequestParam("password") String password);
}
