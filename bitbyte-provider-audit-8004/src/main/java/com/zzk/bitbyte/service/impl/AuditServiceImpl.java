package com.zzk.bitbyte.service.impl;

import com.zzk.bitbyte.mapper.AuditExtendMapper;
import com.zzk.bitbyte.mapper.AuditMapper;
import com.zzk.bitbyte.po.Audit;
import com.zzk.bitbyte.po.extend.AuditExtend;
import com.zzk.bitbyte.po.query.AuditQueryVo;
import com.zzk.bitbyte.service.AuditService;
import com.zzk.bitbyte.util.AuditState;
import com.zzk.bitbyte.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author: zzk
 * @Date: 2020-02-11 10:29
 */
@Service
@Transactional
public class AuditServiceImpl implements AuditService {

    @Autowired
    AuditMapper auditMapper;

    @Autowired
    AuditExtendMapper auditExtendMapper;

    @Override
    public Audit getAuditByAuditId(String auditId) throws Exception {
        Util.validateStr(auditId,"审核ID");
        return auditMapper.selectByPrimaryKey(auditId);
    }

    @Override
    public AuditExtend getAuditExtendByAuditId(String auditId) throws Exception {
        Util.validateStr(auditId,"审核ID");
        return auditExtendMapper.getAuditExtendByAuditId(auditId);
    }

    @Override
    public List<AuditExtend> getAuditListByQueryVo(AuditQueryVo queryVo) throws Exception {
        Assert.notNull(queryVo,"查询对象不能为空!");
        return auditExtendMapper.getAuditListByQueryVo(queryVo);
    }

    @Override
    public Integer getAuditCountByQueryVo(AuditQueryVo queryVo) {
        Assert.notNull(queryVo,"查询对象不能为空!");
        return auditExtendMapper.getAuditCountByQueryVo(queryVo);
    }

    /**
     * 提交审核
     *
     * @param articleId
     */
    @Override
    public Audit addAudit(String articleId) throws Exception {
        Util.validateStr(articleId,"文章ID");
        Audit audit = new Audit();
        audit.setAuditArticle(articleId);
        audit.setAuditState(AuditState.AUDIT_INIT.getValueId());
        Date now = new Date();
        audit.setAuditId(UUID.randomUUID().toString());
        audit.setCreateat(now);
        audit.setUpdateat(now);
        auditMapper.insert(audit);
        return audit;
    }

    /**
     * 审核通过
     *
     * @param auditId
     */
    @Override
    public void auditPass(String auditId, String userId) throws Exception {
        Util.validateStr(auditId,"审核ID");
        Util.validateStr(auditId,"用户ID");
        Audit audit = getAuditByAuditId(auditId);
        Assert.notNull(audit,"审核对象不存在!");
        audit.setAuditUser(userId);
        audit.setAuditState(AuditState.AUDIT_SUCCESS.getValueId());
        Date now = new Date();
        audit.setAuditTime(now);
        audit.setUpdateat(now);
        auditMapper.updateByPrimaryKey(audit);
    }

    /**
     * 审核拒绝
     *
     * @param auditId
     * @param reason
     */
    @Override
    public void auditRefuse(String auditId, String reason, String userId) throws Exception {
        Audit audit = getAuditByAuditId(auditId);
        Assert.notNull(audit,"审核对象不存在!");
        audit.setAuditUser(userId);
        audit.setAuditState(AuditState.AUDIT_REFUSE.getValueId());
        audit.setAuditReason(reason);
        Date now = new Date();
        audit.setAuditTime(now);
        audit.setUpdateat(now);
        auditMapper.updateByPrimaryKey(audit);
    }

    @Override
    public void auditCancel(String auditId) throws Exception {
        Audit audit = getAuditByAuditId(auditId);
        Assert.notNull(audit,"审核对象不存在!");
        audit.setAuditState(AuditState.AUDIT_INIT.getValueId());
        audit.setAuditUser(null);
        audit.setAuditTime(null);
        audit.setAuditReason(null);
        audit.setAuditMore(null);
        auditMapper.updateByPrimaryKey(audit);
    }
}
