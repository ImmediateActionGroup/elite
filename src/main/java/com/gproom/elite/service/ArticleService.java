package com.gproom.elite.service;

import com.gproom.elite.common.dto.ArticleAddDTO;
import com.gproom.elite.common.vo.ArticleVO;
import com.gproom.elite.common.vo.PageVO;

/**
 * created by weixeushan
 * at 2018/1/10- 11:56
 */

public interface ArticleService {
    /**
     * 分页查询
     * @param offset
     * @param limit
     * @return
     */
    PageVO<ArticleVO> pageQuery(int offset, int limit);

    /**
     * 文章添加
     * @param articleAddDTO
     */
    void add(ArticleAddDTO articleAddDTO);

    ArticleVO findOneById(Long id);
}
