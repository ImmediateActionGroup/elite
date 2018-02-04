package com.gproom.elite.exception;

import com.gproom.elite.common.enums.ExceptionEnums;
import lombok.Data;

/**
 * 自定义异常
 * @Author xueshan.wei
 * @Date 2018/2/4 下午5:26
 */
@Data
public class BusinessException extends RuntimeException{
    private ExceptionEnums exceptionEnums;

    public BusinessException(String message, ExceptionEnums exceptionEnums) {
        super(message);
        this.exceptionEnums = exceptionEnums;
    }

    public BusinessException(ExceptionEnums exceptionEnums){
        super(exceptionEnums.getMessage());
        this.exceptionEnums = exceptionEnums;
    }
}
