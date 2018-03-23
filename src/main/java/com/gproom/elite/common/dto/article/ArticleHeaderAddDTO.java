package com.gproom.elite.common.dto.article;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author weixueshan
 * @data 2018/3/23 13:43
 * @desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleHeaderAddDTO {

    private Long id;
    private Long userId;
    private Long boardId;
    private String title;
    private String type;
    private String shortContent;

}
