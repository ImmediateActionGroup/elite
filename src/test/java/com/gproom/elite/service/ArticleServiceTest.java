package com.gproom.elite.service;

import com.gproom.elite.EliteApplicationTests;
import com.gproom.elite.service.impl.ArticleServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * created by weixeushan
 * at 2018/1/10- 14:03
 */
public class ArticleServiceTest extends EliteApplicationTests {

    @Autowired
    private ArticleServiceImpl articleServiceImpl;

    @Test
    public void testGenerateId() throws Exception{
        System.out.println(articleServiceImpl.generateId());
    }
}
