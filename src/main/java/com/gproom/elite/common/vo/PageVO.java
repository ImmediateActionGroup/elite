package com.gproom.elite.common.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * created by weixeushan
 * at 2018/1/10- 14:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageVO<T> {
    private int totals;
    private int limit;
    private int offset;
    private List<T> data;

    public static <T> PageVO<T> buildPage(int totals, int limit, int offset, List<T> data){
        return PageVO.<T>builder()
                .totals(totals)
                .limit(limit)
                .offset(offset)
                .data(data)
                .build();
    }
}
