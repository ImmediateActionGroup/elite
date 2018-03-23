package com.gproom.elite.model.dao;

import com.gproom.elite.model.Board;
import com.gproom.elite.model.BoardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BoardMapper {
    long countByExample(BoardExample example);

    int deleteByExample(BoardExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Board record);

    int insertSelective(Board record);

    List<Board> selectByExample(BoardExample example);

    Board selectByPrimaryKey(Long id);

    List<Board> selectAll();

    int updateByExampleSelective(@Param("record") Board record, @Param("example") BoardExample example);

    int updateByExample(@Param("record") Board record, @Param("example") BoardExample example);

    int updateByPrimaryKeySelective(Board record);

    int updateByPrimaryKey(Board record);
}