package com.zzk.bitbyte.service.fallback;

import com.zzk.bitbyte.po.Record;
import com.zzk.bitbyte.service.RecordService;
import com.zzk.bitbyte.util.ResponseState;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: zzk
 * @Date: 2020-01-21 21:18
 */
@Component
public class RecordServiceFallbackFactory implements FallbackFactory<RecordService> {
    @Override
    public RecordService create(Throwable cause) {
        return new RecordService() {
            @Override
            public ResponseState getRecordListByUserId(String userId) {
                return ResponseState.error("查询记录列表失败,请稍后重试!", Const.SERVICE_PROVIDER_ERROR);
            }

            @Override
            public ResponseState addRecord(Record record) {
                return ResponseState.error("记录添加失败,请稍后重试!", Const.SERVICE_PROVIDER_ERROR);
            }
        };
    }
}
