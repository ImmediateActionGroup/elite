package com.gproom.elite.service.impl;

import com.gproom.elite.common.dto.ArticleAddDTO;
import com.gproom.elite.common.enums.BizTagEnums;
import com.gproom.elite.common.vo.ArticleVO;
import com.gproom.elite.common.vo.PageVO;
import com.gproom.elite.model.Article;
import com.gproom.elite.model.repository.ArticleRepository;
import com.gproom.elite.service.ArticleService;
import com.gproom.elite.utils.DateUtils;
import com.gproom.elite.utils.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * created by weixeushan
 * at 2018/1/10- 13:49
 */
@Service
@Slf4j
public class ArticleServiceImpl extends BaseService implements ArticleService {
    @PostConstruct
    @Override
    public void init() {
        this.idWorker = new IdWorker(this.idCenterId, BizTagEnums.ARTICLE.getValue());
    }

    @Autowired
    ArticleRepository articleRepository;

    public Page<Article> page(int offset, int limit) {
        PageRequest request = new PageRequest(offset - 1, limit, null);
        return articleRepository.findAll(request);
    }

    @Override
    public PageVO<ArticleVO> pageQuery(int offset, int limit) {
        Page<Article> page = page(offset, limit);
        List<Article> articles = page.getContent();
        List<ArticleVO> articleVOS = null;
        if(articles != null && articles.size() > 0){
            articleVOS = articles.stream().map(item ->{
                return ArticleVO.builder()
                        .id(item.getId())
                        .title(item.getTitle())
                        .content(item.getContent())
                        .createdTime(item.getCreatedTime())
                        .lastModifyTime(item.getLastModifyTime())
                        .build();
            }).collect(Collectors.toList());
        }
        return PageVO.buildPage(articleVOS.size(),
                limit, offset, articleVOS);
    }

    @Override
    public void add(ArticleAddDTO articleAddDTO) {
        log.info("创建文章, {}", articleAddDTO);
        Date now = DateUtils.getNow();
        Long id = generateId();
        Article article = Article.builder()
                .id(id)
                .title(articleAddDTO.getTitle())
                .content(articleAddDTO.getContent())
                .createdTime(now)
                .lastModifyTime(now)
                .build();
        articleRepository.save(article);
        log.info("创建文章成功, {}", article);
    }

    @Override
    public ArticleVO findOneById(Long id) {
        Article article = articleRepository.findOne(id);
        return ArticleVO.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .createdTime(article.getCreatedTime())
                .lastModifyTime(article.getLastModifyTime())
                .build();
    }
}
