package com.zzk.bitbyte.po.query;

import com.zzk.bitbyte.po.Notice;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author: zzk
 * @Date: 2020-03-08 10:23
 */
@Setter
@Getter
public class NoticeQueryVo extends QueryVo{
    Notice notice;

    List<String> noticeTopicList;
}
