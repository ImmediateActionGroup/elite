package com.gproom.elite.service;

import com.gproom.elite.EliteApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author xueshan.wei
 * @Date 2018/4/1 上午1:03
 */
public class CacheTest extends EliteApplicationTests{
    @Autowired
    private CacheTestService cacheTestService;

    @Test
    public void test() throws Exception{
        cacheTestService.cacheTest("hello", true);
        cacheTestService.cacheTest("hello", true);
        cacheTestService.cacheTest("hello1", true);

    }

}
