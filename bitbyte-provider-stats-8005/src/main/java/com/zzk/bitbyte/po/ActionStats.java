package com.zzk.bitbyte.po;

import lombok.Data;

/**
 * 互动数据(泛指关注，点赞，评论等互动动作的数据)
 * @Author: zzk
 * @Date: 2020-02-06 16:12
 */
@Data
public class ActionStats extends Stats {

    private String articleId;

}
