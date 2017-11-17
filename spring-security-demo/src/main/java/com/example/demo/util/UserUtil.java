package com.example.demo.util;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * @author LC
 * @date 2017/11/16
 */
public class UserUtil {

    /**
     * 获取当前用户
     *
     * @return
     */
    public static User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = null;
        if (authentication != null) {
            principal = authentication.getPrincipal();
        }
        if (principal != null && principal instanceof User) {
            return (User) principal;
        }
        return null;
    }

}
 