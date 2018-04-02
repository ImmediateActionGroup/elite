package com.gproom.elite.utils;

import org.aspectj.lang.JoinPoint;
import org.springframework.util.Assert;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author xueshan.wei
 * @Date 2018/3/23 下午10:10
 */
public class GlobalMethodInvokeContextHolder {

    private static ThreadLocal<Method> currentInterceptorMethod = new ThreadLocal<>();
    private static ThreadLocal<JoinPoint> currentJoinPoint = new ThreadLocal<>();

    private static Map<String, Method> INVOKED_METHOD_CACHE = new ConcurrentHashMap<>();

    private static Object CACHE_LOCK = new Object();

    public static JoinPoint currentJoinPoint() {
        return currentJoinPoint.get();
    }

    private static void setCurrentJoinPoint(JoinPoint joinPoint) {
        currentJoinPoint.set(joinPoint);
    }

    private static void setCurrentInterceptorMethod(Method method) {
        currentInterceptorMethod.set(method);
    }

    public static Method currentInterceptorMethod(){
        return currentInterceptorMethod.get();
    }

    public static Object [] getArgs(){
        JoinPoint joinPoint = currentJoinPoint.get();
        checkJoinPointNotNull(joinPoint);

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

    public static void setCurrentInvokedContext(JoinPoint joinPoint){
        checkJoinPointNotNull(joinPoint);
        currentJoinPoint.set(joinPoint);
        String invokedMethodName = joinPoint.getSignature().toLongString();
        Method invokedMethod = null;
        if(INVOKED_METHOD_CACHE.containsKey(invokedMethodName)){
            invokedMethod = INVOKED_METHOD_CACHE.get(invokedMethodName);
        }else {
            invokedMethod = getAndCache(joinPoint);
        }
        setCurrentInterceptorMethod(invokedMethod);
    }

    private static Method getAndCache(JoinPoint joinPoint){
        String invokedMethodName = joinPoint.getSignature().toLongString();

        synchronized (CACHE_LOCK){
            if(INVOKED_METHOD_CACHE.containsKey(invokedMethodName)){
                return INVOKED_METHOD_CACHE.get(invokedMethodName);
            }else {
                Method invokedMethod = AopUtils.getMethod(joinPoint);
                INVOKED_METHOD_CACHE.put(invokedMethodName, invokedMethod);
                return invokedMethod;
            }
        }
    }

    private static void checkJoinPointNotNull(JoinPoint joinPoint){
        Assert.notNull(joinPoint, "make sure the joinPoint is not null");
    }
}
