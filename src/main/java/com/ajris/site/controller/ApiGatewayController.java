package com.ajris.site.controller;

import com.ajris.site.client.BackendClient;
import com.ajris.site.model.Blog;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@RestController
public class ApiGatewayController {
    private final BackendClient backendClient;

    public ApiGatewayController(BackendClient backendClient) {
        this.backendClient = backendClient;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/blogs")
    @CrossOrigin(origins = "*")
    public Collection<Blog> goodBeers() {
        return backendClient.getBlogs()
                .getContent();
    }

    public Collection<Blog> fallback() {
        return new ArrayList<>();
    }
}
