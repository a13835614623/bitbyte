package com.zzk.bitbyte.service;

import com.zzk.bitbyte.po.Record;
import com.zzk.bitbyte.service.fallback.RecordServiceFallbackFactory;
import com.zzk.bitbyte.util.ResponseState;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "BITBYTE-RECORD",fallbackFactory = RecordServiceFallbackFactory.class)
public interface RecordService {
    /**
     * 根据用户id获取记录
     * @param userId 用户id
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseState getRecordListByUserId(@RequestParam("userId") String userId);

    /**
     * 添加记录
     * @param record 记录
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseState addRecord(@Validated @RequestBody Record record);
}
