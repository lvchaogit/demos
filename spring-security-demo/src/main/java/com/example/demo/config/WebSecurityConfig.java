package com.example.demo.config;

import com.example.demo.service.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * securityConfig配置
 * @author LC
 * @date 2017/11/14
 */
@Configuration
@EnableWebSecurity
/**
 * EnableGlobalMethodSecurity 来启用基于注解的安全性
 */
@EnableGlobalMethodSecurity(prePostEnabled  = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public UserDetailsService userDetailsService() { //覆盖写userDetailsService方法 (1)
        return new UserSecurityService();

    }

    /**
     * 不进行安全验证的地址配置，类似于静态文件，资源文件等；
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/frame/**","/js/**","/login.html");
    }

    /**
     * 用于配置验证路径，对哪些进行验证，登录默认路径等
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            //跳过
            .antMatchers("/","/login/ajax").permitAll()
            //所有请求都需要验证
            .anyRequest().authenticated()
            .and()
            // 指定登录页面的请求路径
            .formLogin().loginPage("/login_page")
            // 登陆处理路径
            .loginProcessingUrl("/login").permitAll()
            .and()
            .logout().permitAll().and()
            //关闭csrf
            .csrf().disable();

    }

    /**
     * configureGlobal方法的名字不重要，然而，重要的是只在一个被@EnableWebSecurity,
     * @EnableGlobalMethodSecurity，或者@EnableGlobalAuthentication注解的类中配置
     * AuthenticationManagerBuilder，否则会有不可预知的后果。(摘自Spring Security 参考手册)
     *
     * 该方法用于验证如何进行身份验证，此处采用的是自定义身份验证，即自己定义验证的方法，
     * 详细的请参见：《Spring Security 参考手册》中《验证》栏目的描述
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    //@Bean
    //public MyUsernamePasswordAuthenticationFilter myUsernamePasswordAuthenticationFilter() throws Exception {
    //    MyUsernamePasswordAuthenticationFilter myFilter = new MyUsernamePasswordAuthenticationFilter();
    //    myFilter.setAuthenticationManager(authenticationManagerBean());
    //    myFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler());
    //    myFilter.setAuthenticationFailureHandler(authenticationFailureHandler());
    //    myFilter.setRememberMeServices(tokenBasedRememberMeServices());
    //    return myFilter;
    //}
    //
    //@Bean
    //public AuthenticationSuccessHandler authenticationSuccessHandler() {
    //    return new SimpleUrlAuthenticationSuccessHandler("/login/success");
    //}
    //
    //@Bean
    //public AuthenticationFailureHandler authenticationFailureHandler() {
    //    return new SimpleUrlAuthenticationFailureHandler("/login/failure");
    //}
}
 