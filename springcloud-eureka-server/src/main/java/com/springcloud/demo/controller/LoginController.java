package com.springcloud.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LC
 * @date 2017/11/20
 */

@RestController
public class LoginController {
    //@Bean
    //@LoadBalanced
    //RestTemplate restTemplate() {
    //    return new RestTemplate();
    //}
    //
    //@Autowired
    //RestTemplate restTemplate;
    //
    //@RequestMapping(value = "/client", method = RequestMethod.GET)
    //public String client() {
    //    return restTemplate.getForEntity("http://IHOUSE-PRO/index", String.class)
    //        .getBody();
    //}
    //


    @RequestMapping( value = "/login")
    public String login(){

        return "login";
    }

    @RequestMapping("/")
    public String home(){

        return "home";
    }

}
 