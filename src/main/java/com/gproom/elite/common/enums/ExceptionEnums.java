package com.gproom.elite.common.enums;

import lombok.Getter;

/**
 * created by weixeushan
 * at 2018/1/10- 11:33
 */
@Getter
public enum ExceptionEnums {
    SUCCESS("000000", "成功"),

    PARAMETER_VALID_ERROR("0000002", "参数验证错误"),

    ARTICLE_ADD_ERROR("100000", "添加文章出错"),

    ENTITY_ADD_ERROR("1000001", "添加实体出错"),

    PERMISSION_CHECK_ERROR("900000", "没有权限进行操作"),

    OTHER_EXCEPTION("999999", "其他异常")
    ;
    private String code;
    private String message;

    ExceptionEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
