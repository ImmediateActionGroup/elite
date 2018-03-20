package com.gproom.elite.common.enums;

import lombok.Getter;

/**
 * 数据库删除字段枚举类
 * @Author xueshan.wei
 * @Date 2018/3/20 下午10:40
 */
@Getter
public enum DeleteFlagEnum {
    TRUE(1),
    FAlSE(0)
    ;

    private int value;

    DeleteFlagEnum(int value) {
        this.value = value;
    }
}
