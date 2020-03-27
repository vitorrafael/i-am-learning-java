package com.vitorrafael.config;

import com.vitorrafael.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// Configures the WebSecurity (Spring Security)
// Enable security throughout all methods
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Authorize any request that is authenticated with httpBasic
        // antMatcher allows to control the access to the endpoint according to the role
        http.authorizeRequests()
                .antMatchers("/*/protected/**").hasRole("USER") // When accessing this endpoint, the user must have the role USER
                .antMatchers("/*/admin/**").hasRole("ADMIN") // When accessing this endpoint, the user must have the role ADMIN
               .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Authentication with database
        auth.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    // @Autowired
    // public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
           // Will do the authentication in memory process before reaching the endpoint

        // auth.inMemoryAuthentication()
        //         .withUser("vitor").password("{noop}vitor000").roles("USER")
        //        .and()
        //         .withUser("admin").password("{noop}admin").roles("USER", "ADMIN");
    // }
}
