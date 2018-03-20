package com.gproom.elite.model.dao;

import com.gproom.elite.model.ArticleInfo;
import com.gproom.elite.model.ArticleInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleInfoMapper {
    long countByExample(ArticleInfoExample example);

    int deleteByExample(ArticleInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleInfo record);

    int insertSelective(ArticleInfo record);

    List<ArticleInfo> selectByExampleWithBLOBs(ArticleInfoExample example);

    List<ArticleInfo> selectByExample(ArticleInfoExample example);

    ArticleInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArticleInfo record, @Param("example") ArticleInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") ArticleInfo record, @Param("example") ArticleInfoExample example);

    int updateByExample(@Param("record") ArticleInfo record, @Param("example") ArticleInfoExample example);

    int updateByPrimaryKeySelective(ArticleInfo record);

    int updateByPrimaryKeyWithBLOBs(ArticleInfo record);

    int updateByPrimaryKey(ArticleInfo record);
}