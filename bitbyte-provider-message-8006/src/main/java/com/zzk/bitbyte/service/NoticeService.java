package com.zzk.bitbyte.service;

import com.zzk.bitbyte.po.Notice;
import com.zzk.bitbyte.po.query.NoticeQueryVo;

import java.util.List;

/**
 * @Author: zzk
 * @Date: 2020-03-06 22:28
 */
public interface NoticeService {
    /**
     * 发布系统消息
     * @param notice
     */
    void publishNotice(Notice notice) throws Exception;

    /**
     * 根据查询对象查询notice
     * @param queryVo
     * @return
     */
    List<Notice> findNoticeListByQueryVo(NoticeQueryVo queryVo) throws Exception;

    /**
     * 根据查询对象查询notice数量
     * @param queryVo
     * @return
     */
    Integer findNoticeCountByQueryVo(NoticeQueryVo queryVo) throws Exception;
}
