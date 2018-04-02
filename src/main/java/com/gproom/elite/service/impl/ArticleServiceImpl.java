package com.gproom.elite.service.impl;

import com.gproom.elite.common.dto.article.ArticleAddDto;
import com.gproom.elite.common.dto.article.ArticleHeaderAddDTO;
import com.gproom.elite.common.dto.article.ArticleInfoAddDTO;
import com.gproom.elite.common.enums.BizTagEnums;
import com.gproom.elite.common.enums.ExceptionEnums;
import com.gproom.elite.common.vo.page.PageRequest;
import com.gproom.elite.common.vo.page.PageResponse;
import com.gproom.elite.exception.BusinessException;
import com.gproom.elite.model.ArticleInfo;
import com.gproom.elite.model.ArticleStatistic;
import com.gproom.elite.model.dao.ArticleHeaderMapper;
import com.gproom.elite.model.dao.ArticleInfoMapper;
import com.gproom.elite.model.dao.ArticleStatisticMapper;
import com.gproom.elite.service.ArticleHeaderService;
import com.gproom.elite.service.ArticleInfoService;
import com.gproom.elite.service.ArticleService;
import com.gproom.elite.service.BoardService;
import com.gproom.elite.utils.IdWorker;
import com.gproom.elite.utils.UserPrincipalContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;

/**
 * @author weixueshan
 * @data 2018/3/21 11:43
 * @desc
 */
@Service
public class ArticleServiceImpl extends BaseService implements ArticleService {

    @Autowired
    private BoardService boardService;
    @Autowired
    private ArticleHeaderService articleHeaderService;
    @Autowired
    private ArticleInfoService articleInfoService;

    @Override
    public void init() {
        this.idWorker = new IdWorker(this.idCenterId, BizTagEnums.ARTICLE_HEADER.getValue());
    }

    @Override
    public PageResponse findPage(PageRequest pageRequest) {

        return null;
    }

    @Override
    @Transactional
    public boolean addArticle(ArticleAddDto articleAddDto) {
        if(Objects.isNull(articleAddDto)){
            return false;
        }

        /**
         *
         */
        if(!boardService.isExistById(articleAddDto.getBoardId())){
            return false;
        }
        articleAddDto.setId(generateId());
        Long userId = UserPrincipalContextHolder.getCurrentUserPrincipal().getUserId();
        articleAddDto.setUserId(userId);
        boolean articleHeaderAddResult = articleHeaderService.add(assembleArticleHeaderAdd(articleAddDto));

        if(!articleHeaderAddResult){
            throw new BusinessException(ExceptionEnums.ARTICLE_ADD_ERROR);
        }

        boolean articleInfoAddResult = articleInfoService.add(assembleArticleInfoAdd(articleAddDto));
        if(!articleInfoAddResult){
            throw new BusinessException(ExceptionEnums.ARTICLE_ADD_ERROR);
        }

//        String
        return true;
    }
    private ArticleInfoAddDTO assembleArticleInfoAdd(ArticleAddDto articleAddDto){
        return ArticleInfoAddDTO.builder()
                .articleId(articleAddDto.getId())
                .boardId(articleAddDto.getBoardId())
                .content(articleAddDto.getContent())
                .build();
    }
    private ArticleHeaderAddDTO assembleArticleHeaderAdd(ArticleAddDto articleAddDto){
        String content = articleAddDto.getContent();

        String shortContent = content.substring(0, content.length() > 100 ? 95 : content.length());
        return ArticleHeaderAddDTO.builder()
                .id(articleAddDto.getId())
                .boardId(articleAddDto.getBoardId())
                .title(articleAddDto.getTitle())
                .type(articleAddDto.getType())
                .shortContent(shortContent)
                .userId(articleAddDto.getUserId())
                .build();
    }

    private ArticleStatistic assembleArticleStatistic(Long articleId, Long boardId, Date createTime){
        ArticleStatistic articleStatistic = new ArticleStatistic();
        articleStatistic.setArticleId(articleId);
        articleStatistic.setBoardId(boardId);
        articleStatistic.setCreatedTime(createTime);
//        articleStatistic.set

        return null;
    }
}
