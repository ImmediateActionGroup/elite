package com.gproom.elite.common.cache;

/**
 * @author weixueshan
 * @data 2018/4/3 13:38
 * @desc
 */
public interface CacheFactory<K> {

    /**
     * 清空cache
     * @return 清空的缓存的个数
     */
    int clear();

    /**
     * 清理指定key
     * @param key
     */
    default void clearSpecialKey(K key){

    }
}
