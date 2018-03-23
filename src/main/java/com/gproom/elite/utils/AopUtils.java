package com.gproom.elite.utils;

import org.aspectj.lang.JoinPoint;
import org.springframework.util.ClassUtils;


import java.lang.reflect.Method;

/**
 * @Author xueshan.wei
 * @Date 2018/3/23 下午9:25
 */
public class AopUtils {

    /**
     * 通过 JoinPoint 获取 Method ， 注意此Method 获取到的为代理的
     * @param joinPoint
     * @return
     */
    public static Method getMethod(JoinPoint joinPoint){
        Class clazz = joinPoint.getTarget().getClass();
        String invokedMethodName = joinPoint.getSignature().getName();
        Method invokedMethod = ClassUtils.getMethod(clazz, invokedMethodName, null);

        return invokedMethod;
    }
}
