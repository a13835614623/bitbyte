package com.zzk.bitbyte.po;

import lombok.Data;

import java.util.Date;

/**
 * @Author: zzk
 * @Date: 2020-04-09 10:42
 */
@Data
public class FavoriteExtend extends Favorite {
    /**
     * 文章标题
     */
    private String articleTitle;

    private String articleUser;

    private Long articleRead;

    private Date articlePublishTime;

    private Integer articlePart;

    // 作者昵称
    private String userName;

    // 作者头像
    private String userPic;

}
