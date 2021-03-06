package com.gproom.elite.controller;

import com.gproom.elite.annotation.ParameterValid;
import com.gproom.elite.annotation.PermissionCheck;
import com.gproom.elite.common.dto.ArticleAddDTO;
import com.gproom.elite.common.dto.article.ArticleAddDto;
import com.gproom.elite.common.vo.ArticleVO;
import com.gproom.elite.common.vo.PageVO;
import com.gproom.elite.common.vo.ResponseVO;
import com.gproom.elite.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * created by weixeushan
 * at 2018/1/10-14:56
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class ArticleController {
    @Autowired
    private ArticleService articleService;

//    @GetMapping("/articles")
//    public ResponseVO queryPage(@RequestParam Integer offset, @RequestParam Integer limit){
//        PageVO<ArticleVO> pageVO = articleService.pageQuery(offset, limit);
//        return ResponseVO.buildSuccess(pageVO);
//    }

    @PostMapping("/article")
    @PermissionCheck
    @ParameterValid
    public ResponseVO addArticle(@RequestBody ArticleAddDto articleAddDto){
        boolean result = articleService.addArticle(articleAddDto);

        if(result == true){
            return ResponseVO.buildSuccess();
        }else {
            log.error("添加文章出错");
            return ResponseVO.buildFail();
        }
    }
}
