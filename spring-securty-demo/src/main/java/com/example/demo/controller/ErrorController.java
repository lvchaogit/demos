package com.example.demo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * @author LC
 * @date 2017/11/15
 */
@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(Exception.class) //表示捕捉到所有的异常，你也可以捕捉一个你自定义的异常
    public String exception(Exception ex, WebRequest request){
        return "error";
    }
}
 