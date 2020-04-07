package com.zzk.bitbyte.service.impl;

import com.zzk.bitbyte.mapper.RecordExtendMapper;
import com.zzk.bitbyte.mapper.RecordMapper;
import com.zzk.bitbyte.po.Record;
import com.zzk.bitbyte.service.RecordService;
import com.zzk.bitbyte.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private RecordExtendMapper recordExtendMapper;

    @Override
    public void addRecord(String recordContent, String recordUser) throws Exception {
        if (Util.isEmpty(recordContent) || Util.isEmpty(recordUser)) {
            throw new Exception("用户记录内容和记录者不能为空");
        }
        Record record = new Record();
        record.setRecordContent(recordContent);
        record.setRecordUser(recordUser);
        Date d = new Date();
        record.setRecordTime(d);
        record.setCreateat(d);
        record.setUpdateat(d);
        recordMapper.insert(record);
    }

    /**
     * 根据用户id查询记录
     *
     * @param userId 用户id
     * @throws Exception
     */
    @Override
    public List<Record> findRecordsByUserId(String userId) throws Exception {
        Util.validateStr(userId,"用户ID");
        return recordExtendMapper.findRecordsByUserId(userId);
    }

}
