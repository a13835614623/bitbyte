package com.zzk.bitbyte.mapper;

import com.zzk.bitbyte.po.FavoriteGroup;
import com.zzk.bitbyte.po.FavoriteGroupExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FavoriteGroupMapper {
    long countByExample(FavoriteGroupExample example);

    int deleteByExample(FavoriteGroupExample example);

    int deleteByPrimaryKey(String favoriteGroupId);

    int insert(FavoriteGroup record);

    int insertSelective(FavoriteGroup record);

    List<FavoriteGroup> selectByExample(FavoriteGroupExample example);

    FavoriteGroup selectByPrimaryKey(String favoriteGroupId);

    int updateByExampleSelective(@Param("record") FavoriteGroup record, @Param("example") FavoriteGroupExample example);

    int updateByExample(@Param("record") FavoriteGroup record, @Param("example") FavoriteGroupExample example);

    int updateByPrimaryKeySelective(FavoriteGroup record);

    int updateByPrimaryKey(FavoriteGroup record);
}