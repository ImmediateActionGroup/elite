package com.gproom.elite.common.vo.page;

import com.gproom.elite.utils.PageUtils;
import lombok.Data;

/**
 * @author weixueshan
 * @data 2018/3/20 18:31
 * @desc
 */
public class PageRequest {
    /**
     * 页大小
     */
    private Integer pageSize;
    /**
     * 当前页码
     */
    private Integer pageNumber;

    private Integer offset;
    private Integer limit;

    private Long lastRow;

    public Long getLastRow() {
        return lastRow;
    }

    public void setLastRow(Long lastRow) {
        this.lastRow = lastRow;
    }

    public Integer getOffset() {
        return PageUtils.calculateOffset(pageSize, pageNumber);
    }

    public Integer getLimit() {
        return PageUtils.calculateLimit(pageSize, pageNumber);
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
}
