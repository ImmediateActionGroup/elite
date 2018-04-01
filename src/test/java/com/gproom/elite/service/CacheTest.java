package com.gproom.elite.other;

import com.gproom.elite.annotation.Cache;
import com.gproom.elite.common.cache.CacheUtils;
import org.junit.Test;

/**
 * @Author xueshan.wei
 * @Date 2018/4/1 上午1:03
 */
public class CacheTest {
    
    @Test
    public void test() throws Exception{
        cache();
    }

    @Cache(description = "测试缓存")
    private String cache(){
        return "hello";
    }
}
