package com.gproom.elite.common.cache;

import com.gproom.elite.annotation.Cache;
import com.gproom.elite.utils.AopUtils;
import com.gproom.elite.utils.JsonUtils;
import org.aspectj.lang.JoinPoint;
import org.springframework.core.NamedThreadLocal;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.Assert;
import sun.reflect.misc.MethodUtil;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author xueshan.wei
 * @Date 2018/4/1 上午12:07
 */
public class CacheUtils {
    /**
     * 用于存储已经解析过的方法上的注解
     */
    private static Map<Method, CacheDefinition> CACHE_CACHE = new ConcurrentHashMap<>();
    private static Object CACHE_LOCK = new Object();
    private static ThreadLocal<Method> CURRENT_METHOD = new ThreadLocal<>();
    private static ThreadLocal<JoinPoint> CURRENT_JOINPOINT = new NamedThreadLocal<>("currentJoinPoint");

    // 模拟缓存
    private static Map<String, Object> CACHE = new ConcurrentHashMap<>();

    public static Object getCache(JoinPoint joinPoint){
        if(joinPoint == null){
            return null;
        }
        CURRENT_JOINPOINT.set(joinPoint);
        Method currentMethod = AopUtils.getMethod(joinPoint);
        if(currentMethod == null){
            // 这里不会出现这种情况吧 ？
            return null;
        }
        CURRENT_METHOD.set(currentMethod);

        CacheDefinition cacheDefinition = getMethodCacheDefinition(currentMethod);
        if(cacheDefinition == null || cacheDefinition.isCache() == false){
            return null;
        }

        String cacheKey = getCacheKey(joinPoint, cacheDefinition, currentMethod);

        Object cachedValue = CACHE.get(cacheKey);
        // TODO: 2018/4/1 这里需要获取缓存的内容 
        return cachedValue;
    }

    private static String getCacheKey(JoinPoint joinPoint, CacheDefinition cacheDefinition, Method method){
        String cacheKey = null;
        if(cacheDefinition.getCacheType() == CacheType.METHOD){
            cacheKey = generateKeyMethod(method);
        }else if(cacheDefinition.getCacheType() == CacheType.DEFAULT){
            if(cacheDefinition.isNoParameters()){
                cacheKey = generateKeyMethod(method);
            }else {
                cacheKey = generateKeyMethodAndParameter(joinPoint, method);
            }
        }
        return cacheKey;
    }

    /**
     * 获取方法上 @Cache 注解的属性值
     * @param method 带有 @Cache 注解的方法
     * @return 注解的属性值
     */
    private static CacheDefinition getMethodCacheDefinition(Method method){
        if(method == null){
            return null;
        }
        if(CACHE_CACHE.containsKey(method)){
            return CACHE_CACHE.get(method);
        }else {
            synchronized (CACHE_LOCK){
                if(CACHE_CACHE.containsKey(method)){
                    return CACHE_CACHE.get(method);
                }else {
                    Cache cache = AnnotationUtils.findAnnotation(method, Cache.class);
                    CacheDefinition cacheDefinition = parseCacheDefinition(method, cache);
                    CACHE_CACHE.put(method, cacheDefinition);
                    return cacheDefinition;
                }
            }
        }
    }

    /**
     * 设置缓存
     */
    public static void setCache(Object cacheValue){
        if(cacheValue == null){
            return;
        }

        Method method = CURRENT_METHOD.get();
        CacheDefinition cacheDefinition = CACHE_CACHE.get(method);
        if(cacheDefinition == null || cacheDefinition.isCache() == false){
            // 没有缓存注解 或者 不需要缓存
            return;
        }

        // 根据缓存策略以及缓存类型进行缓存
        JoinPoint joinPoint = CURRENT_JOINPOINT.get();
        // TODO: 2018/4/1 这里先采用模拟缓存
        String cacheKey = getCacheKey(joinPoint, cacheDefinition, method);
        CACHE.put(cacheKey, cacheValue);
        System.out.println("已经缓存了");
    }

    
    private static CacheDefinition parseCacheDefinition(Method method, Cache cache){
        if(cache == null || method == null){
            return null;
        }
        Map values = AnnotationUtils.getAnnotationAttributes(cache);
        CacheDefinition cacheDefinition = new CacheDefinition();
        cacheDefinition.setMethod(method);
        cacheDefinition.setAnnotation(cache);
        cacheDefinition.setCache((Boolean) values.get("value"));
        cacheDefinition.setDescription((String) values.get("description"));
        cacheDefinition.setStrategy((CacheStrategy) values.get("strategy"));
        cacheDefinition.setCacheType((CacheType) values.get("cacheType"));

        // 如果不需要缓存则不解析了
        if(cacheDefinition.isCache() == false){
            return cacheDefinition;
        }
        Class [] methodParameterTypes = method.getParameterTypes();
        cacheDefinition.setMethodParameterTypes(methodParameterTypes);
        return cacheDefinition;
    }

    private static String generateKeyMethod(Method method){
        String cacheKey = null;
        String name = method.getName();
        Class clazz = method.getDeclaringClass();
        cacheKey = clazz.getName() + "." + name;
        return cacheKey;
    }

    private static String generateKeyMethodAndParameter(JoinPoint joinPoint, Method method){
        String cacheKey = null;
        CacheParameterProperties parameterProperties = new CacheParameterProperties();
        parameterProperties.setValues(joinPoint.getArgs());
        parameterProperties.setMethodName(method.getName());
        cacheKey = JsonUtils.toJson(parameterProperties);
        return cacheKey;
    }
}
