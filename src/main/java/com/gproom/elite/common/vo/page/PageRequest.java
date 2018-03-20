package com.gproom.elite.common.vo.page;

import lombok.Data;

/**
 * @author weixueshan
 * @data 2018/3/20 18:31
 * @desc
 */
@Data
public class PageRequest {
    /**
     * 页大小
     */
    private Integer pageSize;
    /**
     * 当前页码
     */
    private Integer pageNumber;


}
