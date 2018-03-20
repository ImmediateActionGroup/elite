package com.gproom.elite.common.enums;

import lombok.Getter;

/**
 * created by weixeushan
 * at 2018/1/10- 13:43
 */
@Getter
public enum BizTagEnums {
    ARTICLE_HEADER(1L, "000001"),
    ARTICLE_INFO(2L, "000010"),
    ARTICLE_STATISTIC(3L, "000011"),

    BOARD(4L, "000100"),
    USER(5L, "000101"),

    ;

    private long value;
    private String name;

    BizTagEnums(Long value, String name) {
        this.value = value;
        this.name = name;
    }

    public static BizTagEnums index(long value){
        BizTagEnums [] values = BizTagEnums.values();
        for(BizTagEnums item : values){
            if(item.getValue() == value){
                return item;
            }
        }
        return null;
    }
}
