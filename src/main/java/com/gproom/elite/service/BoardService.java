package com.gproom.elite.service;

import com.gproom.elite.common.dto.board.BoardAddDto;
import com.gproom.elite.common.dto.board.BoardDTO;

import java.util.List;

/**
 * @author weixueshan
 * @data 2018/3/21 11:12
 * @desc
 */
public interface BoardService {

    /**
     * 增加 board
     * @param boardAddDto
     * @return
     */
    boolean addBoard(BoardAddDto boardAddDto);

    /**
     * 通过 boardId 查询
     * @param boardId board id
     * @return 实体或null
     */
    BoardDTO findById(Long boardId);

    boolean isExistById(Long boardId);

    /**
     * 查询所有的
     * @return
     */
    List<BoardDTO> findAll();


}
