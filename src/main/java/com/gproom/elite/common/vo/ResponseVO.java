package com.gproom.elite.common.vo;

import com.gproom.elite.common.enums.ExceptionEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by weixeushan
 * at 2018/1/10- 11:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseVO<T> {
    private String code;
    private String message;
    private T data;

    public static ResponseVO buildSuccess(){
        return buildSuccess("success", null);
    }


    public static ResponseVO buildFail(){
        return build(ExceptionEnums.OTHER_EXCEPTION.getCode(),
                ExceptionEnums.OTHER_EXCEPTION.getMessage(),
                null);
    }

    public static ResponseVO buildSuccess(String message){
        return buildSuccess(message, null);
    }

    public static ResponseVO buildSuccess(Object data){
        return build(ExceptionEnums.SUCCESS.getCode(), ExceptionEnums.SUCCESS.getMessage(), data);
    }

    public static ResponseVO buildSuccess(String message, Object data){
        return build(ExceptionEnums.SUCCESS.getCode(), message, data);
    }
    public static ResponseVO build(ExceptionEnums exceptionEnums){
        return build(exceptionEnums.getCode(), exceptionEnums.getMessage(), null);
    }
    public static <T> ResponseVO build(String code, String message, T data){
        return ResponseVO.builder().code(code)
                .message(message)
                .data(data)
                .build();
    }
}
