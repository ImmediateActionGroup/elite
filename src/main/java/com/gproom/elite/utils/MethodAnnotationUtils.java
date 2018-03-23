package com.gproom.elite.utils;

import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author xueshan.wei
 * @Date 2018/3/23 下午9:21
 */
public class MethodAnnotationUtils {
    private static ConcurrentHashMap<Method, List<Class>> METHOD_ANNOTATION_CACHE =
            new ConcurrentHashMap<>();
    private static final Object CACHE_LOCK = new Object();

    public static boolean isMethodContainAnnotation(Method invokedMethod, Class annotation){
        if(METHOD_ANNOTATION_CACHE.containsKey(invokedMethod)){
            return isContain(invokedMethod, annotation);
        }else {
            return cacheAndJudgeIsContain(invokedMethod, annotation);
        }
    }

    private static boolean cacheAndJudgeIsContain(Method invokedMethod, Class aimAnnotation){
        synchronized (CACHE_LOCK){
            if(METHOD_ANNOTATION_CACHE.containsKey(invokedMethod)){
                return isContain(invokedMethod, aimAnnotation);
            }else {
                Annotation[] annotations = AnnotationUtils.getAnnotations(invokedMethod);
                List<Class> cache = new ArrayList<>();
                boolean flag = false;
                for(Annotation item : annotations){
                    if(item.annotationType().getName().equals(aimAnnotation.getName())){
                        flag = true;
                    }
                    cache.add(item.annotationType());
                }
                METHOD_ANNOTATION_CACHE.put(invokedMethod, cache);
                return flag;
            }
        }
    }

    private static boolean isContain(Method invokedMethod, Class annotation){
        List<Class> cache = METHOD_ANNOTATION_CACHE.get(invokedMethod);
        if(cache != null && cache.contains(annotation)){
            return true;
        }
        return false;
    }
}
