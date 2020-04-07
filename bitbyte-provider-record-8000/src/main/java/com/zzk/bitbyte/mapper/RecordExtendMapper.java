package com.zzk.bitbyte.mapper;

import com.zzk.bitbyte.po.Record;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecordExtendMapper {
    /**
     * 根据用户id查询记录
     * @param userId 用户id
     * @throws Exception
     */
    public List<Record> findRecordsByUserId(String userId) throws Exception;
}
