package com.gproom.elite.config;

import com.gproom.elite.common.cache.CacheUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author xueshan.wei
 * @Date 2018/3/31 下午11:57
 */
@Aspect
@Component
@Slf4j
public class CacheAop {

    @Pointcut("@annotation(com.gproom.elite.annotation.Cache)")
    public void cachePoint(){}

    @Around("cachePoint()")
    public Object cacheAround(ProceedingJoinPoint joinPoint) throws Throwable{
        Object cachedValue = CacheUtils.getCache(joinPoint);
        if(cachedValue != null){
            log.info("命中缓存, 直接返回值");
            return cachedValue;
        }
        Object result = joinPoint.proceed();
        log.info("未命中缓存，查询后保存值并返回");
        CacheUtils.setCache(result);
        return result;
    }
}
