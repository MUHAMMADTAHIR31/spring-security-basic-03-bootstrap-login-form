/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.security.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author Dell
 */
@Configuration
@EnableWebSecurity
public class DemoSecurityConfig  extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       
        //add our users for in memory auth
        
        User.UserBuilder theUser = User.withDefaultPasswordEncoder();
        
        auth.inMemoryAuthentication()
            .withUser(theUser.username("Tahir").password("12345").roles("EMP"))
            .withUser(theUser.username("Sarang").password("12345").roles("EMP","MANAGER"))
            .withUser(theUser.username("Ali").password("12345").roles("EMP","ADMIN"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/").hasRole("EMP")
            .antMatchers("/leaders/**").hasRole("MANAGER")
            .antMatchers("/systems/**").hasRole("ADMIN")
            .and().formLogin()
            .loginPage("/showMyLoginPage")
            .loginProcessingUrl("/authenticateTheUser")
            .permitAll().and()
            .logout().permitAll()
            .and().exceptionHandling().accessDeniedPage("/access-denied");
    }
}
