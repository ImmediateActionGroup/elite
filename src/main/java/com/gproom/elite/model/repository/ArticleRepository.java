package com.gproom.elite.model.repository;

import com.gproom.elite.model.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * created by weixeushan
 * at 2018/1/10- 11:29
 */
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {

}
