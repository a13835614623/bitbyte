package com.zzk.bitbyte.mapper;

import com.zzk.bitbyte.po.Notice;
import com.zzk.bitbyte.po.query.NoticeQueryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zzk
 * @Date: 2020-03-08 10:27
 */
@Mapper
public interface NoticeExtendMapper {
    /**
     * 根据查询对象查询notice
     * @param queryVo
     * @return
     */
    List<Notice> findNoticeListByQueryVo(NoticeQueryVo queryVo);

    /**
     * 根据查询对象查询数量
     * @param queryVo
     * @return
     */
    Integer findNoticeCountByQueryVo(NoticeQueryVo queryVo);
}
