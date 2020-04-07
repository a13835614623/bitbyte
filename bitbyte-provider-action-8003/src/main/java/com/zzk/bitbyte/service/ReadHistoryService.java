package com.zzk.bitbyte.service;

/**
 * @Author: zzk
 * @Date: 2020-04-06 10:49
 */
public interface ReadHistoryService {
    /**
     * 添加阅读记录
     * @param articleId
     * @param userId
     */
    void addReadHistory(String articleId,String userId);

}
