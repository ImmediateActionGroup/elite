package com.gproom.elite.test;

import com.gproom.elite.annotation.TestAop;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weixueshan
 * @data 2018/3/26 15:36
 * @desc
 */
@RestController("real-test")
@RequestMapping("/test")
public class TestController implements ControllerInterface{

    @GetMapping("/hello")
    @TestAop
    public String hello(){
        return "hello test";
    }
}
