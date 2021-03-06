package com.gproom.elite.service;

import com.gproom.elite.common.dto.article.ArticleAddDto;
import com.gproom.elite.common.vo.page.PageRequest;
import com.gproom.elite.common.vo.page.PageResponse;

/**
 * @Author xueshan.wei
 * @Date 2018/3/20 下午10:59
 */
public interface ArticleService {

    /**
     * 添加文章
     * @param articleAddDto
     * @return
     */
    boolean addArticle(ArticleAddDto articleAddDto);

    PageResponse findPage(PageRequest pageRequest);
}
