package com.gproom.elite.service.impl;

import com.gproom.elite.annotation.Cache;
import com.gproom.elite.service.CacheTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author xueshan.wei
 * @Date 2018/4/1 上午1:01
 */
@Service
@Slf4j
public class CacheTestServiceImpl implements CacheTestService{

    @Override
    @Cache(description = "测试缓存")
    public String cacheTest(String parameter, boolean isNumber) {
        log.info("测试缓存......");
        return "hello cache" + parameter + isNumber;
    }
}
