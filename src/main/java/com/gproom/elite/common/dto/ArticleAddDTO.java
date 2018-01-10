package com.gproom.elite.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by weixeushan
 * at 2018/1/10- 14:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleAddDTO {
    private String title;
    private String content;
}
