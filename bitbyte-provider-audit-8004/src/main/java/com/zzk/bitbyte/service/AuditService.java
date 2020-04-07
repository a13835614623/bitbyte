package com.zzk.bitbyte.service;

import com.zzk.bitbyte.po.Audit;
import com.zzk.bitbyte.po.extend.AuditExtend;
import com.zzk.bitbyte.po.query.AuditQueryVo;

import java.util.List;

/**
 * 文章审核服务
 *
 * @Author: zzk
 * @Date: 2020-02-11 10:29
 */
public interface AuditService {
    /**
     * 根据审核id获取审核
     *
     * @param auditId
     * @return
     */
    Audit getAuditByAuditId(String auditId) throws Exception;

    /**
     * 根据审核id获取审核扩展对象
     * @param auditId
     * @return
     * @throws Exception
     */
    AuditExtend getAuditExtendByAuditId(String auditId) throws Exception;

    /**
     * 根据查询对象获取审核列表
     *
     * @param queryVo
     */
    List<AuditExtend> getAuditListByQueryVo(AuditQueryVo queryVo) throws Exception;

    /**
     * 根据查询对象查询审核数量
     *
     * @param queryVo
     * @return
     */
    Integer getAuditCountByQueryVo(AuditQueryVo queryVo);

    /**
     * 提交审核
     *
     * @param articleId 文章id
     */
    Audit addAudit(String articleId) throws Exception;

    /**
     * 审核通过
     *
     * @param auditId
     */
    void auditPass(String auditId, String userId) throws Exception;

    /**
     * 审核拒绝
     *
     * @param auditId
     * @param reason
     */
    void auditRefuse(String auditId, String reason, String userId) throws Exception;

    /**
     * 审核撤销
     * @param auditId
     */
    void auditCancel(String auditId) throws Exception;
}
