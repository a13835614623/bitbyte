package com.zzk.bitbyte.po.extend;

import com.zzk.bitbyte.po.Audit;
import lombok.Data;

/**
 * @Author: zzk
 * @Date: 2020-02-11 20:20
 */
@Data
public class AuditExtend extends Audit {

    private ArticleExtend article;

}
