package com.gproom.elite.pay.transfer;

/**
 * @author weixueshan
 * @data 2018/4/3 14:13
 * @desc
 */
public class ApiInvokeFactory<REQ, RES, API, APICONFIG extends ApiConfig> implements ApiInvoke<REQ, RES, API> {
    private APICONFIG apiconfig;
    @Override
    public RES invoke(API api, REQ requet) {
        return null;
    }
}
