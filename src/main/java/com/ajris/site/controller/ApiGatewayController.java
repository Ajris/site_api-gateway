package com.ajris.site.controller;

import com.ajris.site.client.BackendClient;
import com.ajris.site.model.BlogData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiGatewayController {
    private final BackendClient backendClient;

    public ApiGatewayController(BackendClient backendClient) {
        this.backendClient = backendClient;
    }

    @GetMapping("blog")
    @CrossOrigin
    public ResponseEntity<List<?>> getBlogPosts() {
        return backendClient.getBlogPosts();
    }

    @GetMapping("technology")
    @CrossOrigin
    public ResponseEntity<List<?>> getTechnologies() {
        return backendClient.getTechnologies();
    }

    @GetMapping("project")
    @CrossOrigin
    public ResponseEntity<List<?>> getProjects() {
        return backendClient.getProjects();
    }

    @PostMapping("blog")
    @CrossOrigin
    public ResponseEntity<Long> addBlogPost(@RequestBody BlogData blogData){
        return backendClient.saveBlog(blogData);
    }
}
