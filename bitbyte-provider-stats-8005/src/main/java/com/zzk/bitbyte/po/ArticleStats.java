package com.zzk.bitbyte.po;

import lombok.Data;

/**
 * @Author: zzk
 * @Date: 2020-02-03 22:09
 */
@Data
public class ArticleStats extends Stats {

    private String publishTime;//发布日期
    private Integer part;//博客分区
    private String readNum;//阅读量
    private String tags;//标签
    private String user;//作者
}
