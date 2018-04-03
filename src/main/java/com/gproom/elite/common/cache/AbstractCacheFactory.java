package com.gproom.elite.common.cache;

/**
 * @author weixueshan
 * @data 2018/4/2 16:30
 * @desc
 */
public abstract class AbstractCacheFactory<K, V> implements CacheFactory<K>{

    protected abstract void setCache(K cacheKey, V cacheValue);

    protected abstract V getCache(K cacheKey);
}
