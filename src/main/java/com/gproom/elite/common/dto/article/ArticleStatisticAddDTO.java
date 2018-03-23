package com.gproom.elite.common.dto.article;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author weixueshan
 * @data 2018/3/23 13:47
 * @desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleStatisticAddDTO {
    private Long id;
    private Long boardId;

    private Long articleId;
}
