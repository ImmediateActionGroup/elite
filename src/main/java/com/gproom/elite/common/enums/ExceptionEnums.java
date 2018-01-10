package com.gproom.elite.common.enums;

import lombok.Getter;

/**
 * created by weixeushan
 * at 2018/1/10- 11:33
 */
@Getter
public enum ExceptionEnums {
    NO_EXCEPTION("000000", "no exception"),
    EXCEPTION("999999", "exception")
    ;
    private String code;
    private String message;

    ExceptionEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
