package com.gproom.elite.pay.transfer;

/**
 * @author weixueshan
 * @data 2018/4/3 14:11
 * @desc
 */
public interface ApiInvoke<REQ, RES, API> {

    RES invoke(API api, REQ requet);
}
