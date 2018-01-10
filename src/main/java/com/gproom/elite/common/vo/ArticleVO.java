package com.gproom.elite.common.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * created by weixeushan
 * at 2018/1/10- 11:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleVO {
    private Long            id;
    private String          title;
    private String          content;
    private Date            createdTime;
    private Date            lastModifyTime;
}
