package com.gproom.elite.common.dao;

import com.gproom.elite.common.vo.page.PageRequest;

import java.util.List;

/**
 * @author weixueshan
 * @data 2018/4/4 17:49
 * @desc
 */
public interface BaseDao<T, KeyType> {
    List<T> findPage(PageRequest pageRequest);

    List<T> selectIn(List<KeyType> keys, List<KeyType> keys2);
}
