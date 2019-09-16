package com.ajris.site.controller;

import com.ajris.site.client.BackendClient;
import com.ajris.site.model.BlogInformation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiGatewayController {
    private final BackendClient backendClient;

    public ApiGatewayController(BackendClient backendClient) {
        this.backendClient = backendClient;
    }

    @GetMapping("/blogs")
    @CrossOrigin
    public List<BlogInformation> goodBeers() {
        return backendClient.getBlogPosts().getBody();
    }
}
