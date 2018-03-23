package com.gproom.elite.controller;

import com.gproom.elite.annotation.ParameterValid;
import com.gproom.elite.annotation.PermissionCheck;
import com.gproom.elite.common.dto.TestParam;
import com.gproom.elite.common.dto.article.ArticleAddDto;
import com.gproom.elite.common.enums.ExceptionEnums;
import com.gproom.elite.exception.BusinessException;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/testPermission")
    @PermissionCheck
    public String testPermission(){
        return "permission check success";
    }

    @PostMapping("/hello2")
    @PermissionCheck
    @ParameterValid
    public String hello2(@RequestBody TestParam param) {
        return "hello2";
    }
}
