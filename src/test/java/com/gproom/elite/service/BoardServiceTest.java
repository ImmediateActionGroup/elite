package com.gproom.elite.service;

import com.gproom.elite.EliteApplicationTests;
import com.gproom.elite.common.dto.board.BoardAddDto;
import com.gproom.elite.common.dto.board.BoardDTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author weixueshan
 * @data 2018/3/23 14:07
 * @desc
 */
public class BoardServiceTest extends EliteApplicationTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testFindById() throws Exception{
        Long id = 61244205661700096L;

        BoardDTO boardDTO = boardService.findById(id);
        System.out.println(boardDTO);
    }

    @Test
    public void testAdd() throws Exception{
        BoardAddDto boardAddDto = BoardAddDto.builder()
                .boardName("测试")
                .boardDescription("描述")
                .build();
        boolean result = boardService.addBoard(boardAddDto);

        boolean [] expects = {true};
        boolean [] actuals = {result};
        Assert.assertArrayEquals(expects, actuals);
    }

    @Test
    public void testFindAll() throws Exception{
        List<BoardDTO> boardDTOS = boardService.findAll();

        System.out.println(boardDTOS.size());
    }
}
