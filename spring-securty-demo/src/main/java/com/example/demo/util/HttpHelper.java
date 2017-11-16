package com.example.demo.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LC
 * @date 2017/11/15
 */
public class HttpHelper {

    public static boolean isAjaxRequest(HttpServletRequest request) {
        String header = request.getHeader("X-Requested-With");
        boolean isAjax = "XMLHttpRequest".equals(header) ? true : false;
        return isAjax;
    }
}
 