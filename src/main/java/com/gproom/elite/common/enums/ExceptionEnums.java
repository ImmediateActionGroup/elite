package com.gproom.elite.common.enums;

import lombok.Getter;

/**
 * created by weixeushan
 * at 2018/1/10- 11:33
 */
@Getter
public enum ExceptionEnums {
    SUCCESS("000000", "success"),
    OTHER_EXCEPTION("999999", "exception")
    ;
    private String code;
    private String message;

    ExceptionEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
