package com.gproom.elite.service.impl;

import com.gproom.elite.common.dto.article.ArticleInfoAddDTO;
import com.gproom.elite.common.enums.DeleteFlagEnum;
import com.gproom.elite.model.ArticleInfo;
import com.gproom.elite.model.dao.ArticleInfoMapper;
import com.gproom.elite.service.ArticleInfoService;
import com.gproom.elite.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * @author weixueshan
 * @data 2018/3/23 14:43
 * @desc
 */
@Service
@Slf4j
public class ArticleInfoServiceImpl implements ArticleInfoService {
    @Autowired
    private ArticleInfoMapper articleInfoMapper;
    @Override
    public boolean add(ArticleInfoAddDTO articleInfoAddDTO) {
        if(Objects.isNull(articleInfoAddDTO)){
            return false;
        }

        Date now = DateUtils.getNow();

        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setId(articleInfoAddDTO.getArticleId());
        articleInfo.setBoardId(articleInfoAddDTO.getBoardId());
        articleInfo.setContent(articleInfoAddDTO.getContent());
        articleInfo.setDeleteFlag(DeleteFlagEnum.FAlSE.getValue());
        articleInfo.setCreatedTime(now);
        articleInfo.setLastModifyTime(now);
        articleInfo.setArticleId(articleInfoAddDTO.getArticleId());

        int result = articleInfoMapper.insert(articleInfo);
        if(result > 0){
            return true;
        }
        return false;
    }
}
