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
public class ResponseVO {
    private String code;
    private String message;
    private Object data;

    public static ResponseVO buildSuccess(){
        return buildSuccess("success", null);
    }

    public static ResponseVO buildFail(){
        return ResponseVO.builder()
                .code(ExceptionEnums.EXCEPTION.getCode())
                .message("fail")
                .data(null)
                .build();
    }

    public static ResponseVO buildSuccess(String message){
        return buildSuccess(message, null);
    }

    public static ResponseVO buildSuccess(Object data){
        return buildSuccess(ExceptionEnums.NO_EXCEPTION.getCode(), data);
    }

    public static ResponseVO buildSuccess(String message, Object data){
        return buildSuccess(ExceptionEnums.NO_EXCEPTION.getCode(), message, data);
    }

    public static ResponseVO buildSuccess(String code, String message, Object data){
        return ResponseVO.builder()
                .code(code)
                .message(message)
                .data(data)
                .build();
    }
}
