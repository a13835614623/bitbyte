package com.zzk.bitbyte.service;

import com.zzk.bitbyte.util.ResponseState;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 博客审核服务
 * @Author: zzk
 * @Date: 2020-02-14 10:32
 */
@FeignClient(value = "BITBYTE-AUDIT")
public interface AuditService {
    /**
     * 提交审核
     *
     * @param articleId 文章id
     */
    @RequestMapping("/commit")
    ResponseState commit(@RequestParam("articleId") String articleId);

}
