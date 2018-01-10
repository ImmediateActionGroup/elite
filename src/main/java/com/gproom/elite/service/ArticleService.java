package com.gproom.elite.service;

import com.gproom.elite.common.dto.ArticleAddDTO;
import com.gproom.elite.common.vo.ArticleVO;
import com.gproom.elite.common.vo.PageVO;

/**
 * created by weixeushan
 * at 2018/1/10- 11:56
 */

public interface ArticleService {
    PageVO<ArticleVO> pageQuery(int offset, int limit);
    void add(ArticleAddDTO articleAddDTO);
}
