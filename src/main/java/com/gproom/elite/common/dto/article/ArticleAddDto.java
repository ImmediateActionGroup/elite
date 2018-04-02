package com.gproom.elite.common.dto.article;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author weixueshan
 * @data 2018/3/21 11:28
 * @desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleAddDto {
    private Long id;
    @NotBlank(message = "文章标题不能为空")
    private String title;
    @NotBlank(message = "文章内容不能为空")
    private String content;
    private Long userId;
    @NotNull(message = "板块id不能为空")
    private Long boardId;
    private String type;
}
