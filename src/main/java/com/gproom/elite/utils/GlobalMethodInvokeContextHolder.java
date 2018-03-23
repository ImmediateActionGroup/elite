package com.gproom.elite.utils;

import org.aspectj.lang.JoinPoint;

import java.lang.reflect.Method;

/**
 * @Author xueshan.wei
 * @Date 2018/3/23 下午10:10
 */
public class GlobalMethodInvokeContextHolder {

    private static ThreadLocal<Method> currentInterceptorMethod = new ThreadLocal<>();
    private static ThreadLocal<JoinPoint> currentJoinPoint = new ThreadLocal<>();

    public static JoinPoint currentJoinPoint() {
        return currentJoinPoint.get();
    }

    public static void setCurrentJoinPoint(JoinPoint joinPoint) {
        currentJoinPoint.set(joinPoint);
    }

    public static void setCurrentInterceptorMethod(Method method) {
        currentInterceptorMethod.set(method);
    }

    public static Method currentInterceptorMethod(){
        return currentInterceptorMethod.get();
    }

    public static Object [] getArgs(){
        JoinPoint joinPoint = currentJoinPoint.get();
        Object [] args = joinPoint.getArgs();
        return args;
    }

    public static Object getFirstArg(){
        Object [] args = getArgs();
        if(args != null && args.length > 0){
            return args[0];
        }
        return null;
    }
}
