package com.gproom.elite.common.vo.page;

import java.util.List;

/**
 * @author weixueshan
 * @data 2018/3/21 11:24
 * @desc
 */
public class PageResponse<T> extends PageRequest{

    private List<T> data;
    private Integer totals;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getTotals() {
        return totals;
    }

    public void setTotals(Integer totals) {
        this.totals = totals;
    }
}
