package com.gproom.elite.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author xueshan.wei
 * @Date 2018/2/4 下午5:16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageRequest {
    private Integer offset;
    private Integer limit;
    private Integer pageSize;
    private Integer pageNumber;
}
