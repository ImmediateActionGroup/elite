package com.gproom.elite.model.repository;

import com.gproom.elite.EliteApplicationTests;
import com.gproom.elite.model.Article;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * created by weixeushan
 * at 2018/1/10- 14:19
 */
public class ArticleRespositoryTest extends EliteApplicationTests {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void testQueryPage() throws Exception {
    }
}
