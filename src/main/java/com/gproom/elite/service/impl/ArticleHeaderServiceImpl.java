package com.gproom.elite.service.impl;

import com.gproom.elite.common.dto.article.ArticleHeaderAddDTO;
import com.gproom.elite.common.enums.DeleteFlagEnum;
import com.gproom.elite.model.ArticleHeader;
import com.gproom.elite.model.dao.ArticleHeaderMapper;
import com.gproom.elite.service.ArticleHeaderService;
import com.gproom.elite.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * @author weixueshan
 * @data 2018/3/23 14:29
 * @desc
 */
@Service
@Slf4j
public class ArticleHeaderServiceImpl extends BaseService implements ArticleHeaderService {

    @Autowired
    private ArticleHeaderMapper articleHeaderMapper;
    @Override
    public void init() {

    }

    @Override
    public boolean add(ArticleHeaderAddDTO articleHeaderAddDTO) {
        if(Objects.isNull(articleHeaderAddDTO)){
            return false;
        }
        Date now = DateUtils.getNow();
        ArticleHeader articleHeader = new ArticleHeader();
        articleHeader.setId(articleHeaderAddDTO.getId());
        articleHeader.setUserId(articleHeaderAddDTO.getUserId());
        articleHeader.setCreatedTime(now);
        articleHeader.setLastModifyTime(now);
        articleHeader.setDeleteFlag(DeleteFlagEnum.FAlSE.getValue());
        articleHeader.setShortContent(articleHeaderAddDTO.getShortContent());
        articleHeader.setTitle(articleHeaderAddDTO.getTitle());
        articleHeader.setType(articleHeaderAddDTO.getType());
        articleHeader.setBoardId(articleHeaderAddDTO.getBoardId());

        int result = articleHeaderMapper.insert(articleHeader);
        if(result > 0){
            return true;
        }
        return false;
    }
}
