package com.ajris.site.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/aqweqweqw").authenticated();
//        http.build()
//        http
//                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/api/*").permitAll().and()
//                .requestMatcher(new RequestHeaderRequestMatcher("Authorization"))
//                .authorizeRequests()
//                .antMatchers("/**").authenticated();
    }
}