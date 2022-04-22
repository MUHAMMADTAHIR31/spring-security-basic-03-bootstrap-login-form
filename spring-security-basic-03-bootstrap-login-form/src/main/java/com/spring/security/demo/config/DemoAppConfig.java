/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.security.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author Dell
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.spring.security.demo")
public class DemoAppConfig  {
    
    @Bean
    public ViewResolver viewResolver(){
        
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        
        // set prefix 
        viewResolver.setPrefix("/WEB-INF/view/");
       
        //set suffix
        viewResolver.setSuffix(".jsp");
        
        // return the view Resovler
        return viewResolver;
    }
}
