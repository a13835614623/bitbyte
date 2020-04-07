package com.zzk.bitbyte.service;

import com.zzk.bitbyte.po.Record;

import java.util.List;

/**
 * 用户记录管理
 *
 * @author zzk
 */
public interface RecordService {
    /**
     * 添加用户记录
     *
     * @param recordContent 记录内容
     * @param recordUser    记录的用户ID
     * @throws Exception
     */
    public void addRecord(String recordContent, String recordUser) throws Exception;

    /**
     * 根据用户id查询记录
     * @param userId 用户id
     * @throws Exception
     */
    public List<Record> findRecordsByUserId(String userId) throws Exception;
}
