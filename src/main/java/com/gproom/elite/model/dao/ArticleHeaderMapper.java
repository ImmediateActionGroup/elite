package com.gproom.elite.model.dao;

import com.gproom.elite.common.vo.page.PageRequest;
import com.gproom.elite.model.ArticleHeader;
import com.gproom.elite.model.ArticleHeaderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleHeaderMapper {
    long countByExample(ArticleHeaderExample example);

    int deleteByExample(ArticleHeaderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleHeader record);

    int insertSelective(ArticleHeader record);

    List<ArticleHeader> selectByExample(ArticleHeaderExample example);

    ArticleHeader selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArticleHeader record, @Param("example") ArticleHeaderExample example);

    int updateByExample(@Param("record") ArticleHeader record, @Param("example") ArticleHeaderExample example);

    int updateByPrimaryKeySelective(ArticleHeader record);

    int updateByPrimaryKey(ArticleHeader record);

    List<ArticleHeader> findPage(PageRequest pageRequest);
}