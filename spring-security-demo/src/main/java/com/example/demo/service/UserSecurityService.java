package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 自定义校验
 * @author LC
 * @date 2017/11/14
 */
public class UserSecurityService implements UserDetailsService {

    /**
     * 实现UserDetailsService接口
     * loadUserByUsername方法用于根据用户名获取密码，角色信息，
     * 实现该方法，可根据实际场景，自定义获取用户信息方法，如：数据库、统一验证服务器等；
     * 将用户信息拼装成security的user对象进行返回，则在验证的时候，根据此处返回的用户信息进行验证对比
     *
     * @param name  登录名
     * @return user 用户对象
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        //登录名 参数传入
        String loginName = name;
        //密码 根据相应场景进行获取
        String pwd = "testpwd";
        //角色 可根据相应场景进行获取
        //注：此处角色code需加上ROLE_前缀，因为security比对的时候会默认带这个前缀
        //代码：SecurityExpressionRoot.hasAnyAuthorityName()
        String ruleCode = "ROLE_Admin";

        if(!"admin".equals(loginName)){
            ruleCode = "ROLE_User";
        }

        List<GrantedAuthority> authorityArrayList = new ArrayList<GrantedAuthority>();
        //拼装角色集合
        authorityArrayList.add(new SimpleGrantedAuthority(ruleCode));

        //拼装User对象，用于校验
        User user = new User(loginName,pwd,authorityArrayList);

        return user;
    }
}
 