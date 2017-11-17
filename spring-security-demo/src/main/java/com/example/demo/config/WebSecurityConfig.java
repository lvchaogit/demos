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

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/frame/**","/js/**","/login.html");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/","/login/ajax").permitAll()
            .anyRequest().authenticated()
            .and()
            // 指定登录页面的请求路径
            .formLogin().loginPage("/login_page")
            // 登陆处理路径
            .loginProcessingUrl("/login").permitAll()
            .and()
            .logout()
            .permitAll().and().csrf().disable();

    }

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
 