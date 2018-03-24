package com.gproom.elite.config;

import com.gproom.elite.interceptor.MethodInterceptor;
import com.gproom.elite.utils.AopUtils;
import com.gproom.elite.utils.GlobalMethodInvokeContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author weixueshan
 * @data 2018/3/20 19:24
 * @desc
 */
@Aspect
//@Component
@Slf4j
public class GlobalInterceptor {

    private static ConcurrentHashMap<Method, List<Class>> METHOD_ANNOTATION_CACHE =
            new ConcurrentHashMap<>();

    private final Object CACHE_LOCK = new Object();
    private List<MethodInterceptor> interceptors;

    public GlobalInterceptor(List<MethodInterceptor> interceptors) {
        this.interceptors = interceptors;
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        setCurrentInvokedMethodAndJoinPoint(joinPoint);

        for (MethodInterceptor interceptor : interceptors) {
            interceptor.doBefore(null);
        }

        Object retVal = joinPoint.proceed();

        return retVal;
    }

    public void setCurrentInvokedMethodAndJoinPoint(JoinPoint joinPoint) {
        GlobalMethodInvokeContextHolder.setCurrentJoinPoint(joinPoint);
        Method invokedMethod = AopUtils.getMethod(joinPoint);
        GlobalMethodInvokeContextHolder.setCurrentInterceptorMethod(invokedMethod);
    }
}
