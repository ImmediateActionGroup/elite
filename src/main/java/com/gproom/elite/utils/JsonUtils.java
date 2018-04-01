package com.gproom.elite.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * json 工具类🔧
 * @Author xueshan.wei
 * @Date 2018/4/1 下午1:15
 */
public class JsonUtils {
//    private static Gson gson = new GsonBuilder().generateNonExecutableJson().create();
    private static Gson gson2 = new GsonBuilder().create();

    public static <T> String toJson(T data){
        return gson2.toJson(data);
    }

    public static <T> T fromJson(String jsonStr, Class classType){
        return (T)gson2.fromJson(jsonStr, classType);
    }

    public static <T> T fromJson(String jsonStr, Type type){
        return (T) gson2.fromJson(jsonStr, type);
    }
}
