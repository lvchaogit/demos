package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户controller
 * @author LC
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/error")
    public String userError() throws Exception {
        throw new Exception("打印错误信息");
    }


    @RequestMapping("/getInfo")
    @PreAuthorize("hasAnyRole('User','Admin')")
    public String getUserInfo(){

        return "返回用户信息成功！";
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
 