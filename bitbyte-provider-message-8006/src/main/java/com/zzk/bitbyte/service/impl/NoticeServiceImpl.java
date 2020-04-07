package com.zzk.bitbyte.service.impl;

import com.zzk.bitbyte.mapper.NoticeExtendMapper;
import com.zzk.bitbyte.mapper.NoticeMapper;
import com.zzk.bitbyte.po.Notice;
import com.zzk.bitbyte.po.query.NoticeQueryVo;
import com.zzk.bitbyte.service.NoticeService;
import com.zzk.bitbyte.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author: zzk
 * @Date: 2020-03-06 22:29
 */
@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeMapper noticeMapper;

    @Autowired
    NoticeExtendMapper noticeExtendMapper;

    /**
     * 发送消息
     *
     * @param notice
     */
    @Override
    public void publishNotice(Notice notice) throws Exception {
        Util.validateObj(notice, "notice");
        Date now = new Date();
        notice.setNoticeId(UUID.randomUUID().toString());
        notice.setCreateat(now);
        notice.setUpdateat(now);
        noticeMapper.insert(notice);
    }

    @Override
    public List<Notice> findNoticeListByQueryVo(NoticeQueryVo queryVo) throws Exception {
        Util.validateObj(queryVo, "查询对象");
        if (queryVo.getCount() > 5) queryVo.setCount(5);
        return noticeExtendMapper.findNoticeListByQueryVo(queryVo);
    }

    @Override
    public Integer findNoticeCountByQueryVo(NoticeQueryVo queryVo) throws Exception {
        Util.validateObj(queryVo, "查询对象");
        return noticeExtendMapper.findNoticeCountByQueryVo(queryVo);
    }
}
