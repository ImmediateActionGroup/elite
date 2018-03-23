package com.gproom.elite.common.dto.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author weixueshan
 * @data 2018/3/23 13:48
 * @desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDTO {

    private Long id;

    private Date createdTime;

    private Date lastModifyTime;

    private String boardName;

    private String boardDescription;

    private Integer deleteFlag;
}
