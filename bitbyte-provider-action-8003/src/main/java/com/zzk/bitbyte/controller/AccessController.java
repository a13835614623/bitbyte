package com.zzk.bitbyte.controller;

import com.zzk.bitbyte.po.Access;
import com.zzk.bitbyte.service.AccessService;
import com.zzk.bitbyte.util.ResponseState;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: zzk
 * @Date: 2020-02-05 11:40
 */
@RestController
@RequestMapping("/action/access")
public class AccessController {
    @Autowired
    AccessService accessService;

    @RequestMapping("/add")
    public ResponseState access(@RequestParam("type")Integer type,
                                @RequestParam("value")Integer value,
                                HttpServletRequest request){
        Access access = new Access();
        access.setAccessIp(getIp(request));
        access.setAccessType(type);
        access.setAccessValue(value);
        accessService.addAccess(access);
        return ResponseState.success("访问成功!");
    }
    /**
     * 获取访问者IP地址
     * <p>在一般情况下使用Request.getRemoteAddr()即可，但是经过nginx等反向代理软件后，这个方法会失效。</p>
     * <p>本方法先从Header中获取X-Real-IP，如果不存在再从X-Forwarded-For获得第一个IP(用,分割)。</p>
     * <p>如果还不存在则调用Request.getRemoteAddr()。</p>
     * @param request
     * @return
     */
    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (StringUtils.isNotBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }
}
