package com.gproom.elite.common.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @Author xueshan.wei
 * @Date 2018/3/23 下午11:33
 */
@Data
public class TestParam {
    @NotBlank(message = "title 不能为空")
    private String title;
}
