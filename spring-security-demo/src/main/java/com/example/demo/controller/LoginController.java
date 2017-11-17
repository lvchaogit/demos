package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.util.HttpHelper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录处理controller
 * @author LC
 * @date 2017/11/14
 */
@RestController
public class LoginController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * 登录页面
     * @param request
     * @return
     */
    @RequestMapping(value = "/login_page", method = RequestMethod.GET)
    public ModelAndView loginPage(HttpServletRequest request) {
        if (HttpHelper.isAjaxRequest(request)) {
            return new ModelAndView("forward:/login/ajax");
        } else {
            return new ModelAndView("html/login");
        }
    }

    @RequestMapping(value = "/login_page/ajax", method = RequestMethod.GET)
    public ModelAndView loginPagebyAjax() {
        return new ModelAndView("ajax/login");
    }

    @RequestMapping(value = "/login/success", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('User','Admin')")
    public String loginSuccess() {
        return "登录成功";
    }


    @RequestMapping(value = "/login/failure", method = RequestMethod.GET)
    public String loginFailure() {
        return "登录失败";
    }

    @RequestMapping(value = "/login/ajax", method = RequestMethod.GET)
    @ResponseBody
    public String loginAjax() {
        System.out.println("请登录！！！！！！！");
        return "请登录！";
    }

    @RequestMapping(value = "/security/user", method = RequestMethod.GET)
    public String securityUser() {
        return "验证用户！";
    }


    @RequestMapping(value = "/security/admin", method = RequestMethod.GET)
    @PreAuthorize("hasRole('Admin')")
    public String securityAdmin(HttpServletRequest request) {
        return "管理员你好";
    }

    @RequestMapping(value = "/user/account", method = RequestMethod.GET)
    public String getUserAcctunt(HttpServletRequest request) {
        return "account";
    }


}
 