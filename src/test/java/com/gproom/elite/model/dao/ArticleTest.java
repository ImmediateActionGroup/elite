package com.gproom.elite.model.dao;

import com.gproom.elite.EliteApplicationTests;
import com.gproom.elite.common.vo.page.PageRequest;
import com.gproom.elite.model.ArticleHeader;
import org.assertj.core.util.Lists;
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

    @Test
    public void testSelectIn() throws Exception{
        List<Long > ids = Lists.newArrayList(new Long [] {62359659948019712L, 62359660187095040L, 62359660103208960L, });

        List<ArticleHeader> list = articleHeaderMapper.selectIn(ids, ids);
        list.stream().forEach(item -> {
            System.out.println(item);
        });
    }
}
