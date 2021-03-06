package com.gproom.elite.exception;

import com.gproom.elite.common.enums.ExceptionEnums;
import com.gproom.elite.common.vo.ResponseVO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常捕捉
 * @Author xueshan.wei
 * @Date 2018/2/4 下午5:27
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 全局异常捕捉
     * @param exception
     * @return
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseVO exceptionHandler(Exception exception){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        if(exception instanceof BusinessException){

            if(exception instanceof ParameterValidException){
                ParameterValidException parameterValidException = (ParameterValidException) exception;
                return ResponseVO.build(parameterValidException.getExceptionEnums(), parameterValidException.getErrors());
            }
            BusinessException businessException = (BusinessException) exception;
            ExceptionEnums exceptionEnums = businessException.getExceptionEnums();
            return ResponseVO.build(exceptionEnums);
        }
        /**
         * 其它错误返回
         */
        return ResponseVO.buildFail();
    }
}
