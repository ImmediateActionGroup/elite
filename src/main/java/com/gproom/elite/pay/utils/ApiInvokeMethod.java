package com.gproom.elite.pay.utils;

/**
 * @Author xueshan.wei
 * @Date 2018/4/3 下午10:11
 */
public interface ApiInvokeMethod<Res, Params> {
    Res get(String url);
    Res get(String url, Params params);
    Res post(String url, Params params);
}
