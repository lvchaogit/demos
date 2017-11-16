package com.example.demo.controller;

import com.example.demo.util.UserUtil;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户controller
 * @author LC
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/error")
    public String userError() throws Exception {
        throw new Exception("打印错误信息");
    }


    @RequestMapping("/getInfo")
    public String getUserInfo(){

        return "返回用户信息成功！";
    }

    @RequestMapping("/getLogin")
    @PreAuthorize("hasAnyRole('User','Admin')")
    public String getLogin(){

        return "login";
    }

    @RequestMapping("/hello")
    public ModelAndView hello(){
        User user = UserUtil.getCurrentUser();
        logger.info("用户名：{}，角色：{}",new String[]{user.getUsername(),user.getAuthorities().toString()});
        return new ModelAndView("hello");
    }
    @RequestMapping("/add")
    @PreAuthorize("hasRole('Admin')")
    public String addUser(){
        return "添加用户信息成功！";
    }


    @RequestMapping("/add123")
    @PreAuthorize("hasRole('Admin11')")
    public String addUsertest(){
        return "添加用户信息成功123！";
    }




}
 