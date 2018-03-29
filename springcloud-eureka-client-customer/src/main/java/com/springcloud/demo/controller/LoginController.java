package com.springcloud.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author LC
 * @date 2017/11/20
 */
@RestController
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private RestTemplate restTemplate; // HTTP 访问操作类


    @RequestMapping("/customer")
    public String customer() {
        String providerMsg = restTemplate.getForEntity("http://PROVIDER-SERVICE/login",
            String.class).getBody();
        return "Hello,Customer! msg from provider : <br/><br/> " + providerMsg;
    }

}
 