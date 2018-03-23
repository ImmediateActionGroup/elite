package com.gproom.elite.service;

import com.gproom.elite.EliteApplicationTests;
import com.gproom.elite.common.dto.article.ArticleAddDto;
import com.gproom.elite.common.user.UserPrincipal;
import com.gproom.elite.utils.UserPrincipalContextHolder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author weixueshan
 * @data 2018/3/23 15:00
 * @desc
 */
public class ArticleServiceTest extends EliteApplicationTests{

    @Autowired
    private ArticleService articleService;

    @Before
    public void before() {
        UserPrincipal userPrincipal = UserPrincipal.builder()
                .userPkey("")
                .userId(11111L)
                .build();
        UserPrincipalContextHolder.setUserPrincipal(userPrincipal);

    }
    @Test
    public void testAdd() throws Exception{

        ArticleAddDto articleAddDto = ArticleAddDto.builder()
                .title("title 标题")
                .content("content")
                .boardId(61244205661700096L)
                .type("吴")
                .build();
        boolean result = articleService.addArticle(articleAddDto);

        System.out.println(result);

    }
}
