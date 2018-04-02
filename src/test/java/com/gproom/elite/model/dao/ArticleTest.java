package com.gproom.elite.model.dao;

import com.gproom.elite.EliteApplicationTests;
import com.gproom.elite.common.vo.page.PageRequest;
import com.gproom.elite.model.ArticleHeader;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author weixueshan
 * @data 2018/3/26 15:54
 * @desc
 */
public class ArticleTest extends EliteApplicationTests {

    @Autowired
    private ArticleHeaderMapper articleHeaderMapper;

    @Test
    public void testFindPage() throws Exception{
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageNumber(1);
        pageRequest.setPageSize(10);
        pageRequest.setLastRow(62359660363255808L);

        List<ArticleHeader> list = articleHeaderMapper.findPage(pageRequest);

        System.out.println(list.size());
    }
}
