package com.gproom.elite.config;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

/**
 * @author weixueshan
 * @data 2018/4/2 10:14
 * @desc
 */
@Component
public class AopTestConcrete extends AopTest{

    @Override
    protected void doBefore(JoinPoint joinPoint) {
        System.out.println("do something......");
    }
}
