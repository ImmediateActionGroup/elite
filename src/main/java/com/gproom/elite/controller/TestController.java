package com.gproom.elite.controller;

import com.gproom.elite.annotation.TestAop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author xueshan.wei
 * @Date 2018/3/24 上午9:23
 */
@RestController
public class TestController {

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/testR")
    @TestAop
    public String test(HttpServletRequest request1){

        request.getContextPath();

        request1.getContextPath();
        return "rrr";
    }
}
