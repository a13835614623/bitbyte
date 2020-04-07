package com.zzk.bitbyte.po.query;

import com.zzk.bitbyte.po.Audit;
import com.zzk.bitbyte.po.query.QueryVo;
import lombok.Data;

/**
 * @Author: zzk
 * @Date: 2020-02-11 11:31
 */
@Data
public class AuditQueryVo extends QueryVo {

    private Audit audit;

    private Integer articlePart;
    // '%Y-%m-%d'
    // 文章投递时间范围开始
    private String articleSubmitTimeStart;
    // '%Y-%m-%d'
    // 文章投递时间范围结束
    private String articleSubmitTimeEnd;

}
