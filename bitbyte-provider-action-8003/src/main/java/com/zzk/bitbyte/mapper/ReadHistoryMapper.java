package com.zzk.bitbyte.mapper;

import com.zzk.bitbyte.po.ReadHistory;
import com.zzk.bitbyte.po.ReadHistoryExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReadHistoryMapper {
    long countByExample(ReadHistoryExample example);

    int deleteByExample(ReadHistoryExample example);

    int deleteByPrimaryKey(String readId);

    int insert(ReadHistory record);

    int insertSelective(ReadHistory record);

    List<ReadHistory> selectByExample(ReadHistoryExample example);

    ReadHistory selectByPrimaryKey(String readId);

    int updateByExampleSelective(@Param("record") ReadHistory record, @Param("example") ReadHistoryExample example);

    int updateByExample(@Param("record") ReadHistory record, @Param("example") ReadHistoryExample example);

    int updateByPrimaryKeySelective(ReadHistory record);

    int updateByPrimaryKey(ReadHistory record);
}