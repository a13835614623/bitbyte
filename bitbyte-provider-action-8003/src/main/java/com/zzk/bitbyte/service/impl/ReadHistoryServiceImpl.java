package com.zzk.bitbyte.service.impl;

import com.zzk.bitbyte.mapper.ReadHistoryMapper;
import com.zzk.bitbyte.po.ReadHistory;
import com.zzk.bitbyte.service.ReadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Author: zzk
 * @Date: 2020-04-06 10:52
 */
@Service
@Transactional
public class ReadHistoryServiceImpl implements ReadHistoryService {

    @Autowired
    private ReadHistoryMapper readHistoryMapper;

    /**
     * 添加阅读记录
     *
     * @param articleId
     * @param userId
     */
    @Override
    public void addReadHistory(String articleId, String userId) {
        ReadHistory readHistory = new ReadHistory();
        Date now = new Date();
        readHistory.setReadArticle(articleId);
        readHistory.setReadUser(userId);
        readHistory.setCreateat(now);
        readHistory.setReadTime(now);
        readHistory.setUpdateat(now);
        readHistoryMapper.insert(readHistory);
    }
}
