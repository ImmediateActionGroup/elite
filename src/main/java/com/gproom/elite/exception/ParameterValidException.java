package com.gproom.elite.exception;

import com.gproom.elite.common.enums.ExceptionEnums;

import java.util.Map;

/**
 * @Author xueshan.wei
 * @Date 2018/3/23 下午11:17
 */
public class ParameterValidException extends BusinessException{
    private Map<String, String > errors;

    public ParameterValidException(ExceptionEnums exceptionEnums, Map<String, String > errors) {
        this.exceptionEnums = exceptionEnums;
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
