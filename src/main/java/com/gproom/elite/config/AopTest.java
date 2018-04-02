package com.gproom.elite.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author weixueshan
 * @data 2018/3/26 15:39
 * @desc
 */
@Aspect
//@Component
public abstract class AopTest {

    @Pointcut("@annotation(com.gproom.elite.annotation.TestAop)")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        this.doBefore(joinPoint);
    }

    protected abstract void doBefore(JoinPoint joinPoint);
}
