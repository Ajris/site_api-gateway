package com.ajris.site.controller;

import com.ajris.site.client.BackendClient;
import com.ajris.site.model.Beer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ApiGatewayController {
    private final BackendClient backendClient;

    public ApiGatewayController(BackendClient backendClient) {
        this.backendClient = backendClient;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/api/coś")
    @CrossOrigin(origins = "*")
    public Collection<Beer> goodBeers() {
        return backendClient.getSth()
                .getContent();
    }
}
