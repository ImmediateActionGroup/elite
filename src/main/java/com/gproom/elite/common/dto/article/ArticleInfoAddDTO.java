package com.gproom.elite.common.dto.article;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author weixueshan
 * @data 2018/3/23 14:32
 * @desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleInfoAddDTO {

    private Long boardId;

    private Long articleId;

    private String content;
}
