package com.gproom.elite.config;

import com.gproom.elite.annotation.PermissionCheck;
import com.gproom.elite.common.enums.ExceptionEnums;
import com.gproom.elite.exception.BusinessException;
import com.gproom.elite.utils.PermissionChecker;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.aop.ProxyMethodInvocation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author weixueshan
 * @data 2018/3/20 19:24
 * @desc
 */
@Aspect
@Component
@Slf4j
public class GlobalInterceptor {

    private final static String PERMISSION_KEY = "pkey";
    private static ConcurrentHashMap<Method, List<Class>> METHOD_ANNOTATION_CACHE =
            new ConcurrentHashMap<>();
    @Autowired
    private PermissionChecker permissionChecker;

    private final Object CACHE_LOCK = new Object();

    @Pointcut("@annotation(com.gproom.elite.annotation.PermissionCheck)")
    public void pointCut(){

    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        /**
         * 权限拦截
         */
        if(isMethodContainAnnotation(joinPoint, PermissionCheck.class)){
            permissionChecker.checkUserPermission(request.getHeader(PERMISSION_KEY));
        }

        Object retVal = joinPoint.proceed();
        joinPoint.getTarget().getClass();

        return retVal;
    }

    private boolean isMethodContainAnnotation(JoinPoint joinPoint, Class annotation){
        Class clazz = joinPoint.getTarget().getClass();
        String invokedMethodName = joinPoint.getSignature().getName();
        Method invokedMethod = ClassUtils.getMethod(clazz, invokedMethodName, null);

        if(METHOD_ANNOTATION_CACHE.containsKey(invokedMethod)){
            return isContain(invokedMethod, annotation);
        }else {
            return cacheAndJudgeIsContain(invokedMethod, annotation);
        }
    }

    private boolean cacheAndJudgeIsContain(Method invokedMethod, Class aimAnnotation){
        synchronized (CACHE_LOCK){
            if(METHOD_ANNOTATION_CACHE.containsKey(invokedMethod)){
                return isContain(invokedMethod, aimAnnotation);
            }else {
                Annotation [] annotations = AnnotationUtils.getAnnotations(invokedMethod);
                List<Class> cache = new ArrayList<>();
                boolean flag = false;
                for(Annotation item : annotations){
                    if(item.annotationType().getName().equals(aimAnnotation.getName())){
                        flag = true;
                    }
                    cache.add(item.getClass());
                }
                METHOD_ANNOTATION_CACHE.put(invokedMethod, cache);
                return flag;
            }
        }
    }

    private boolean isContain(Method invokedMethod, Class annotation){
        List<Class> cache = METHOD_ANNOTATION_CACHE.get(invokedMethod);
        if(cache != null && cache.contains(annotation)){
            return true;
        }
        return false;
    }
}
