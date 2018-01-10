package com.gproom.elite.common.enums;

import lombok.Getter;

/**
 * created by weixeushan
 * at 2018/1/10- 13:43
 */
@Getter
public enum BizTagEnums {
    ARTICLE(1L, "000001");
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
