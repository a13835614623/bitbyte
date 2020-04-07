package com.zzk.bitbyte.mapper;

import com.zzk.bitbyte.po.Audit;
import com.zzk.bitbyte.po.extend.AuditExtend;
import com.zzk.bitbyte.po.query.AuditQueryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zzk
 * @Date: 2020-02-11 11:31
 */
@Mapper
public interface AuditExtendMapper {
    /**
     * 根据查询对象查询审核列表
     * @param queryVo
     * @return
     */
    List<AuditExtend> getAuditListByQueryVo(AuditQueryVo queryVo);

    /**
     * 根据查询对象查询审核数量
     * @param queryVo
     * @return
     */
    Integer getAuditCountByQueryVo(AuditQueryVo queryVo);

    /**
     * 根据auditId查询审核扩展数据
     * @param auditId
     * @return
     * @throws Exception
     */
    AuditExtend getAuditExtendByAuditId(String auditId) throws Exception;

}
