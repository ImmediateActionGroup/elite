package com.gproom.elite.service.impl;

import com.gproom.elite.utils.IdWorker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * created by weixeushan
 * at 2018/1/10- 13:51
 */
@Service
public abstract class BaseService{
    protected IdWorker idWorker;
    @Value("${elite.config.idcenterid}")
    protected Long idCenterId;

    @PostConstruct
    public void initIdWord(){
        this.init();
    }
    public abstract void init();
    public Long generateId(){
        return this.idWorker.nextId();
    }
}
