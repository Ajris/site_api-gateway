package com.ajris.site.controller;

import com.ajris.site.client.BackendClient;
import com.ajris.site.model.BlogInformation;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class ApiGatewayController {
    private final BackendClient backendClient;

    public ApiGatewayController(BackendClient backendClient) {
        this.backendClient = backendClient;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/blogs")
    @CrossOrigin(origins = "*")
    public List<BlogInformation> goodBeers() {
        return backendClient.getBlogs().getBody();
    }

    public List<BlogInformation> fallback() {
        return new ArrayList<>();
    }
}
