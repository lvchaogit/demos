package com.springcloud.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LC
 * @date 2017/11/20
 */

@RestController
public class LoginController {
    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private Registration registration;       // 服务注册
    @Autowired
    private DiscoveryClient discoveryClient; // 服务发现客户端

    @RequestMapping( value = "/login")
    public String login(){
        ServiceInstance instance = serviceInstance();
        logger.info("provider service, host = " + instance.getHost()
            + ", service_id = " + instance.getServiceId());
        return "Hello,Provider!";
    }

    /**
     * 获取当前服务的服务实例
     *
     * @return ServiceInstance
     */
    public ServiceInstance serviceInstance() {
        List<ServiceInstance> list = discoveryClient.getInstances(registration.getServiceId());
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

}
 