package com.gproom.elite.service.impl;

import com.gproom.elite.annotation.Cache;
import com.gproom.elite.service.CacheTestService;
import org.springframework.stereotype.Service;

/**
 * @Author xueshan.wei
 * @Date 2018/4/1 上午1:01
 */
@Service
public class CacheTestServiceImpl implements CacheTestService{

    @Override
    @Cache(description = "测试缓存")
    public String cacheTest(String parameter, boolean isNumber) {
        return "hello cache";
    }
}
