package com.gproom.elite.common.enums;

import lombok.Getter;

/**
 * created by weixeushan
 * at 2018/1/10- 11:33
 */
@Getter
public enum ExceptionEnums {
    SUCCESS("000000", "成功"),

    PERMISSION_CHECK_ERROR("900000", "权限校验失败"),
    OTHER_EXCEPTION("999999", "其他异常")
    ;
    private String code;
    private String message;

    ExceptionEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
