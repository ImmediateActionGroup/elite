package com.gproom.elite.utils;

/**
 * @author weixueshan
 * @data 2018/3/21 11:16
 * @desc
 */
public class PageUtils {
    public static int calculateOffset(int pageSize, int pageNumber){
        pageNumber = pageNumber < 0 ? 1 : pageNumber;
        return (pageNumber - 1) * pageSize;
    }
    public static int calculateLimit(int pageSize, int pageNumber){
        return pageSize;
    }
}
