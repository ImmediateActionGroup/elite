package com.gproom.elite.common.cache;

/**
 * @author weixueshan
 * @data 2018/4/2 17:04
 * @desc
 */
public interface CacheOperate {
    void setCache(String cacheKey, Object cacheValue);

    Object getCache(String cacheKey);
}
