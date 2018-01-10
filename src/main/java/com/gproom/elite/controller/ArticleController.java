package com.gproom.elite.controller;

import com.gproom.elite.common.dto.ArticleAddDTO;
import com.gproom.elite.common.vo.ArticleVO;
import com.gproom.elite.common.vo.PageVO;
import com.gproom.elite.common.vo.ResponseVO;
import com.gproom.elite.model.Article;
import com.gproom.elite.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * created by weixeushan
 * at 2018/1/10- 14:56
 */
@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public ResponseVO queryPage(@RequestParam Integer offset, @RequestParam Integer limit){
        PageVO<ArticleVO> pageVO = articleService.pageQuery(offset, limit);
        return ResponseVO.buildSuccess(pageVO);
    }

    @PostMapping("/article")
    public ResponseVO addArticle(@RequestBody ArticleAddDTO articleAddDTO){
        articleService.add(articleAddDTO);
        return ResponseVO.buildSuccess();
    }
}
