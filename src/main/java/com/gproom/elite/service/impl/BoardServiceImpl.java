package com.gproom.elite.service.impl;

import com.gproom.elite.annotation.Cache;
import com.gproom.elite.common.dto.board.BoardAddDto;
import com.gproom.elite.common.dto.board.BoardDTO;
import com.gproom.elite.common.enums.BizTagEnums;
import com.gproom.elite.common.enums.DeleteFlagEnum;
import com.gproom.elite.common.enums.ExceptionEnums;
import com.gproom.elite.exception.BusinessException;
import com.gproom.elite.model.Board;
import com.gproom.elite.model.dao.BoardMapper;
import com.gproom.elite.service.BoardService;
import com.gproom.elite.utils.DateUtils;
import com.gproom.elite.utils.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author weixueshan
 * @data 2018/3/23 13:57
 * @desc
 */
@Service
@Slf4j
public class BoardServiceImpl extends BaseService implements BoardService{

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public void init() {
        this.idWorker = new IdWorker(this.idCenterId, BizTagEnums.BOARD.getValue());

    }

    @Override
    public boolean addBoard(BoardAddDto boardAddDto) {
        log.info("【添加版块】开始, data:{}",boardAddDto);
        if(boardAddDto != null){
            Board board = new Board();
            board.setId(generateId());
            Date now = DateUtils.getNow();
            board.setBoardName(boardAddDto.getBoardName());
            board.setBoardDescription(boardAddDto.getBoardDescription());
            board.setCreatedTime(now);
            board.setLastModifyTime(now);
            board.setDeleteFlag(DeleteFlagEnum.FAlSE.getValue());
            int result = 0;
            try{
                result = boardMapper.insert(board);
            }catch (Exception e){
                log.error("【添加版块】出错, (可能原因：版块名称重复), data: {}", boardAddDto);
                throw new BusinessException(ExceptionEnums.ENTITY_ADD_ERROR);
            }
            if(result > 0){
                log.info("【添加版块】成功：{}", boardAddDto);
                return true;
            }
        }
        return false;
    }

    @Override
    public BoardDTO findById(Long boardId) {
        if(boardId == null){
            return null;
        }
        Board board = boardMapper.selectByPrimaryKey(boardId);

        return assembleBoard(board);
    }

    @Override
    @Cache(description = "根据版块ID查询版块是否存在")
    public boolean isExistById(Long boardId) {
        BoardDTO boardDTO = findById(boardId);
        if(Objects.nonNull(boardDTO)){
            return true;
        }
        return false;
    }

    private BoardDTO assembleBoard(Board board){
        if(board == null){
            return null;
        }

        return BoardDTO.builder()
                .id(board.getId())
                .createdTime(board.getCreatedTime())
                .lastModifyTime(board.getLastModifyTime())
                .boardName(board.getBoardName())
                .boardDescription(board.getBoardDescription())
                .deleteFlag(board.getDeleteFlag())
                .build();
    }

    @Override
    public List<BoardDTO> findAll() {
        List<Board> boards = boardMapper.selectAll();

        List<BoardDTO> boardDTOS = boards.stream().map(item -> {
            return assembleBoard(item);
        }).collect(Collectors.toList());
        return boardDTOS;
    }
}
