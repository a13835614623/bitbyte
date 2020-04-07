package com.zzk.bitbyte.controller;

import com.zzk.bitbyte.po.Record;
import com.zzk.bitbyte.service.RecordService;
import com.zzk.bitbyte.util.ResponseState;
import com.zzk.bitbyte.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController {

    @Qualifier("recordServiceImpl")
    @Autowired
    RecordService service;

    /**
     * 获取用户操作记录
     * @param userId
     */
    @RequestMapping(value = "/user/get/{userId}", method = RequestMethod.GET)
    public ResponseState getRecordListByUserId(@PathVariable("userId") String userId) throws Exception {
        ResponseState state = new ResponseState();
        List<Record> records = service.findRecordsByUserId(userId);
        state.setStatus(ResponseState.STATUS_SUCCESS);
        state.setData(records);
        state.setMessage("获取用户记录成功!");
        return state;
    }

    /**
     * 添加记录
     * @param record 记录
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseState addRecord(@Validated @RequestBody Record record, BindingResult result) throws Exception {
        Util.handleBindingError(result);
        ResponseState state = new ResponseState();
        state.setStatus(ResponseState.STATUS_SUCCESS);
        service.addRecord(record.getRecordContent(),record.getRecordUser());
        state.setMessage("添加用户记录成功!");
        return state;
    }
}
