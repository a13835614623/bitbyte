package com.zzk.bitbyte.po.query;

import com.zzk.bitbyte.po.extend.ArticleExtend;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 文章查询包装类
 * @Author: zzk
 * @Date: 2019-05-22 12:55
 */
@Data
public class ArticleQueryVo extends QueryVo{
    private ArticleExtend article;

    private Date articlePublishStart;
    private Date articlePublishEnd;

    private List<Integer> articleStateList;
}
