package com.gproom.elite.common.cache;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

/**
 * @author weixueshan
 * @data 2018/4/2 11:30
 * @desc
 */
@Aspect
@Slf4j
public abstract class AbstractCacheManager implements CacheOperate, InitializingBean{
    @Pointcut("@annotation(com.gproom.elite.annotation.Cache)")
    private final void cachePoint(){}
    private AbstractCacheFactory cacheFactory;
    private static final String CACHE_KEY_PREFIX = "cache_key_";
    @Around("cachePoint()")
    private final Object cacheAround(ProceedingJoinPoint joinPoint) throws Throwable{
        doCacheBefore();
        CacheUtils.setCurrentJoinPoint(joinPoint);

        String cacheKey = CACHE_KEY_PREFIX + getCacheKey(joinPoint);
        if(cacheKey != null){
            Object cachedValue = cacheFactory.getCache(cacheKey);
            if(cachedValue != null){
                log.info("命中缓存, 直接返回值");
                return cachedValue;
            }
        }
        log.info("未命中缓存，查询后保存值并返回");
        Object object =  joinPoint.proceed();
        if(cacheKey != null){
            this.setCache(cacheKey, object);
        }
        doCacheAfter();
        return object;
    }

    private String getCacheKey(JoinPoint joinPoint){
        return CacheUtils.getCacheKey(joinPoint);
    }

    protected abstract void doCacheBefore();

    protected abstract void doCacheAfter();


    private void checkCacheContext(){
        Assert.notNull(cacheFactory, "cache factory could't be null");
    }

    protected void setCacheFactory(AbstractCacheFactory abstractCacheFactory) {
        this.cacheFactory = abstractCacheFactory;
    }

    protected AbstractCacheFactory getCacheFactory(){
        return cacheFactory;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        /**
         * 默认为 简单内存缓存
         */
        log.info("初始化为简单内存缓存");
        this.cacheFactory = new SimpleMemoryCacheFactory();
    }

    @Override
    public void setCache(String cacheKey, Object cacheValue) {
        this.cacheFactory.setCache(cacheKey, cacheValue);
    }

    @Override
    public Object getCache(String cacheKey) {
        return this.cacheFactory.getCache(cacheKey);
    }
}
