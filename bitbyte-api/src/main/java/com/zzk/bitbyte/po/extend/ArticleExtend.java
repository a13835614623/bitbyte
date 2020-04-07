package com.zzk.bitbyte.po.extend;

import com.zzk.bitbyte.po.ArticleWithBLOBs;
import lombok.Data;

/**
 * 文章扩展类
 * 添加作者昵称和头像
 * @className: ArticleExtend
 * @author: zzk
 * @date: 2020-01-21 17:38
 */
@Data
public class ArticleExtend extends ArticleWithBLOBs {

    // 作者昵称
    private String userName;

    // 作者头像
    private String userPic;

    // 文章点赞数量
    private Integer articleLikeNum;

    // 文章评论数量
    private Integer articleCommentNum;

}
