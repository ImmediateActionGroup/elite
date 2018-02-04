package com.gproom.elite.controller;

import com.gproom.elite.common.enums.ExceptionEnums;
import com.gproom.elite.exception.BusinessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xueshan.wei
 * @Date 2018/1/22 下午10:52
 */
@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/test")
    public String test(){
        throw new BusinessException(ExceptionEnums.OTHER_EXCEPTION);
    }
}
