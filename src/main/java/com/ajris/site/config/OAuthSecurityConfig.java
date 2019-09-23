package com.ajris.site.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class OAuthSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception{
        http
                .antMatcher("/**").authorizeRequests()
                .antMatchers(HttpMethod.GET,"/blogs").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2ResourceServer().jwt();
    }
}