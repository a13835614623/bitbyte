package com.zzk.bitbyte.service.fallback;

import com.zzk.bitbyte.service.CaService;
import com.zzk.bitbyte.util.ResponseState;
import feign.hystrix.FallbackFactory;

/**
 * @Author: zzk
 * @Date: 2020-02-09 14:33
 */
public class CaServiceFallbackFactory implements FallbackFactory<CaService> {
    @Override
    public CaService create(Throwable cause) {
        return (username, password) -> ResponseState.error("登录失败,服务器发生异常,请稍后重试!", Const.SERVICE_PROVIDER_ERROR);
    }
}
