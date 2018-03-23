package com.gproom.elite.service.impl;

import com.gproom.elite.common.dto.article.ArticleAddDto;
import com.gproom.elite.model.ArticleStatistic;
import com.gproom.elite.model.dao.ArticleHeaderMapper;
import com.gproom.elite.model.dao.ArticleInfoMapper;
import com.gproom.elite.model.dao.ArticleStatisticMapper;
import com.gproom.elite.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author weixueshan
 * @data 2018/3/21 11:43
 * @desc
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleInfoMapper articleInfoMapper;
    @Autowired
    private ArticleHeaderMapper articleHeaderMapper;
    @Autowired
    private ArticleStatisticMapper articleStatisticMapper;

    @Override
    public boolean addArticle(ArticleAddDto articleAddDto) {
        String
        return false;
    }

    private ArticleStatistic assembleArticleStatistic(Long articleId, Long boardId, Date createTime){
        ArticleStatistic articleStatistic = new ArticleStatistic();
        articleStatistic.setArticleId(articleId);
        articleStatistic.setBoardId(boardId);
        articleStatistic.setCreatedTime(createTime);
        articleStatistic.set
    }
}
