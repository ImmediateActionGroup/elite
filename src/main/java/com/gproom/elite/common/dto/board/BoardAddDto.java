package com.gproom.elite.common.dto.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author weixueshan
 * @data 2018/3/21 11:13
 * @desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardAddDto {
    /**
     * 板块名称
     */
    private String boardName;
    /**
     * 板块描述
     */
    private String boardDescription;
}
