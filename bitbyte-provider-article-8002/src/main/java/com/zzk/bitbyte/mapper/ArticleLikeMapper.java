package com.zzk.bitbyte.mapper;

import com.zzk.bitbyte.po.ArticleLike;
import com.zzk.bitbyte.po.ArticleLikeExample;
import com.zzk.bitbyte.po.ArticleLikeKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleLikeMapper {
    long countByExample(ArticleLikeExample example);

    int deleteByExample(ArticleLikeExample example);

    int deleteByPrimaryKey(ArticleLikeKey key);

    int insert(ArticleLike record);

    int insertSelective(ArticleLike record);

    List<ArticleLike> selectByExample(ArticleLikeExample example);

    ArticleLike selectByPrimaryKey(ArticleLikeKey key);

    int updateByExampleSelective(@Param("record") ArticleLike record, @Param("example") ArticleLikeExample example);

    int updateByExample(@Param("record") ArticleLike record, @Param("example") ArticleLikeExample example);

    int updateByPrimaryKeySelective(ArticleLike record);

    int updateByPrimaryKey(ArticleLike record);
}