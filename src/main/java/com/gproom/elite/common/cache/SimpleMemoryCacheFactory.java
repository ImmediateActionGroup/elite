package com.gproom.elite.common.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author weixueshan
 * @data 2018/4/2 16:52
 * @desc
 */
public class SimpleMemoryCacheFactory<K, V> extends AbstractCacheFactory<K, V> {
    private Map<K, V> CACHE = new ConcurrentHashMap<>();
    @Override
    protected void setCache(K cacheKey, V cacheValue) {
        if(cacheKey == null){
            return;
        }
        CACHE.put(cacheKey, cacheValue);
    }

    @Override
    protected V getCache(K cacheKey) {
        return CACHE.get(cacheKey);
    }

    @Override
    public int clear() {
        int size = CACHE.size();
        CACHE.clear();
        return size;
    }

    @Override
    public void clearSpecialKey(K key) {
        if(CACHE.containsKey(key)){
            CACHE.remove(key);
        }
    }
}
