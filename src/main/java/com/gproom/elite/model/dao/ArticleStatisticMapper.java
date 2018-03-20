package com.gproom.elite.model.dao;

import com.gproom.elite.model.ArticleStatistic;
import com.gproom.elite.model.ArticleStatisticExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleStatisticMapper {
    long countByExample(ArticleStatisticExample example);

    int deleteByExample(ArticleStatisticExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleStatistic record);

    int insertSelective(ArticleStatistic record);

    List<ArticleStatistic> selectByExample(ArticleStatisticExample example);

    ArticleStatistic selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArticleStatistic record, @Param("example") ArticleStatisticExample example);

    int updateByExample(@Param("record") ArticleStatistic record, @Param("example") ArticleStatisticExample example);

    int updateByPrimaryKeySelective(ArticleStatistic record);

    int updateByPrimaryKey(ArticleStatistic record);
}