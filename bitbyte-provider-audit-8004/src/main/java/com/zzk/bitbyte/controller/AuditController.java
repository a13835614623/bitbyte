package com.zzk.bitbyte.controller;

import com.zzk.bitbyte.message.MessageProducer;
import com.zzk.bitbyte.po.extend.AuditExtend;
import com.zzk.bitbyte.po.query.AuditQueryVo;
import com.zzk.bitbyte.service.AuditService;
import com.zzk.bitbyte.util.ResponseState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zzk
 * @Date: 2020-02-11 10:27
 */
@RestController
@RequestMapping("/audit")
public class AuditController {
    @Qualifier("auditServiceImpl")
    @Autowired
    private AuditService auditService;

    @Autowired
    MessageProducer messageProducer;

    /**
     * 发送[审核结束]消息
     * @param audit
     */
    public void sendAuditEnd(AuditExtend audit) {
        messageProducer.sendAuditEnd(audit);
    }
    /**
     * 发送[审核撤销]消息
     * @param audit
     */
    public void sendAuditCancel(AuditExtend audit) {
        messageProducer.sendAuditCancel(audit.getAuditArticle());
    }
    /**
     * 根据审核id获取审核
     * @param auditId
     * @return
     */
    @RequestMapping("/get/{auditId}")
    public ResponseState get(@PathVariable("auditId") String auditId) throws Exception {
        return ResponseState.success("查询成功!").setData(auditService.getAuditByAuditId(auditId));
    }
    /**
     * 根据查询对象查询审核列表
     * @return
     */
    @RequestMapping("/list")
    public ResponseState list(@RequestBody AuditQueryVo queryVo) throws Exception {
        return ResponseState.success("查询成功!").setData(auditService.getAuditListByQueryVo(queryVo))
                .setMore(auditService.getAuditCountByQueryVo(queryVo));
    }

    /**
     * 根据查询对象查询审核数量
     * @return
     */
    @RequestMapping("/count")
    public ResponseState count(@RequestBody AuditQueryVo queryVo) throws Exception {
        return ResponseState.success("查询成功!").setData(auditService.getAuditCountByQueryVo(queryVo));
    }

    /**
     * 提交审核
     * @param articleId 文章id
     */
    @RequestMapping("/commit")
    public ResponseState commit(@RequestParam("articleId") String articleId) throws Exception {
        auditService.addAudit(articleId);
        return ResponseState.success("审核提交成功!");
    }

    /**
     * 审核通过
     * @param auditId 审核id
     * @param articleId 文章id
     * @param userId 审核者id
     * @throws Exception
     */
    @RequestMapping("/pass")
    public ResponseState auditPass(@RequestParam("auditId") String auditId,
                                    @RequestParam("articleId") String articleId,
                                   @RequestParam("userId") String userId) throws Exception {
        auditService.auditPass(auditId,userId);
        sendAuditEnd(auditService.getAuditExtendByAuditId(auditId));
        return ResponseState.success("审核结果提交成功!");
    }

    /**
     * 审核拒绝
     * @param auditId
     * @param reason
     */
    @RequestMapping("/refuse")
    public ResponseState auditRefuse(@RequestParam("auditId") String auditId,
                                      @RequestParam("reason") String reason,
                                     @RequestParam("articleId") String articleId,
                                     @RequestParam("userId") String userId) throws Exception {
        auditService.auditRefuse(auditId,reason,userId);
        sendAuditEnd(auditService.getAuditExtendByAuditId(auditId));
        return ResponseState.success("审核结果提交成功!");
    }

    /**
     * 撤销审核
     * @param auditId
     */
    @RequestMapping("/cancel")
    public ResponseState auditCancel(@RequestParam("auditId") String auditId) throws Exception {
        auditService.auditCancel(auditId);
        sendAuditCancel(auditService.getAuditExtendByAuditId(auditId));
        return ResponseState.success("撤销成功!");
    }
}
