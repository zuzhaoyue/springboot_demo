package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by zuzhaoyue on 2019/4/1.
 */
@RestController
public class HelloController {
    @Autowired
    private DiscoveryClient client;
    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public Object get(){
        ServiceInstance serviceInstance = client.getLocalServiceInstance();
        logger.info("/hello,host:" + serviceInstance.getHost() + ",port:" + serviceInstance.getPort()+",serviceId:" + serviceInstance.getServiceId());
        return  "我是生产者";
    }
}
