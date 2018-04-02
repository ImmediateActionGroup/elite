package com.gproom.elite.common.cache;

/**
 * 缓存策略
 * @Author xueshan.wei
 * @Date 2018/4/1 上午12:10
 */
public enum CacheStrategy {
    /**
     * 默认缓存策略，永久缓存直到手动刷新
     */
    DEFAULT,
    /**
     * 有时限限制的缓存，需要额外指定缓存时间
     */
    TIME_LIMIT,
    ;
}
