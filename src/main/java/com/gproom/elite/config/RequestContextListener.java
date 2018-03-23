package com.gproom.elite.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author xueshan.wei
 * @Date 2018/3/23 下午10:00
 */
@Slf4j
@WebListener
@Component
public class RequestContextListener implements ServletRequestListener{
    @Override
    public void requestDestroyed(ServletRequestEvent requestEvent) {
        if (!(requestEvent.getServletRequest() instanceof HttpServletRequest)) {
            throw new IllegalArgumentException(
                    "Request is not an HttpServletRequest: " + requestEvent.getServletRequest());
        }
        HttpServletRequest request = (HttpServletRequest) requestEvent.getServletRequest();

        System.out.println(RequestContextListener.class.getName() + "阿哈哈哈");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

    }
}
