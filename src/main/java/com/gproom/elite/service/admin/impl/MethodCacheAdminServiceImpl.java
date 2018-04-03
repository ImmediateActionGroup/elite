package com.gproom.elite.service.admin.impl;

import com.gproom.elite.common.cache.AbstractCacheFactory;
import com.gproom.elite.config.CacheManager;
import com.gproom.elite.service.admin.MethodCacheAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author weixueshan
 * @data 2018/4/3 11:41
 * @desc
 */
@Service
@Slf4j
public class MethodCacheAdminServiceImpl implements MethodCacheAdminService, InitializingBean{
    @Autowired
    private CacheManager cacheAop;
    private AbstractCacheFactory cacheFactory;

    @Override
    public int clearAll() {
        log.info("清空key ");
        return cacheFactory.clear();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(cacheAop, "cache factory could't be null");
        this.cacheFactory = cacheAop.getCacheFactory();
    }
}
