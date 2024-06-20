package com.quiz.main.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .rememberMe() // Enables remember-me functionality
                .key("uniqueAndSecret") // Key used to identify tokens
                .tokenValiditySeconds(86400); // Sets the validity of the remember-me token (e.g., 1 day)
        // You can also specify a userDetailsService if your application requires it
        // Further configuration...
        
     // Chỉ cho phép user có quyền ADMIN truy cập đường dẫn /admin/**
        http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");
        // Chỉ cho phép user có quyền ADMIN hoặc USER truy cập đường dẫn /user/**
        http.authorizeRequests().antMatchers("/user/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')");
     // Chỉ cho phép user có quyền ADMIN truy cập đường dẫn /admin/**
        http.authorizeRequests().antMatchers("/manager/**").access("hasRole('ROLE_MANAGER')");
        // Chỉ cho phép user có quyền ADMIN hoặc USER truy cập đường dẫn /user/**
        http.authorizeRequests().antMatchers("/teacher/**").access("hasRole('ROLE_TEACHER')");
        
     // Khi người dùng đã login, với vai trò USER, Nhưng truy cập vào trang yêu cầu vai trò ADMIN, sẽ chuyển hướng tới trang /403
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
        
     // Cấu hình cho Login Form.
        http.authorizeRequests().and().formLogin()//
            .loginProcessingUrl("/j_spring_security_login")//
            .loginPage("/login")//
            .defaultSuccessUrl("/user")//
            .failureUrl("/login?message=error")//
            .usernameParameter("username")//
            .passwordParameter("password")
            // Cấu hình cho Logout Page.
            .and().logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/login?message=logout");
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
      auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).
        withUser("kai").password("$2a$04$Q2Cq0k57zf2Vs/n3JXwzmerql9RzElr.J7aQd3/Sq0fw/BdDFPAj.").roles("ADMIN");
      auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).
        withUser("sena").password("$2a$04$Q2Cq0k57zf2Vs/n3JXwzmerql9RzElr.J7aQd3/Sq0fw/BdDFPAj.").roles("USER");
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
}
