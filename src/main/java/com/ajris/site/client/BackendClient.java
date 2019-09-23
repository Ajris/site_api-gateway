package com.ajris.site.client;

import com.ajris.site.model.BlogData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("backend-service")
public interface BackendClient {
    @GetMapping("/api/blog")
    ResponseEntity<List<?>> getBlogPosts();

    @GetMapping("/api/project")
    ResponseEntity<List<?>> getProjects();

    @GetMapping("/api/technology")
    ResponseEntity<List<?>> getTechnologies();

    @PostMapping("/api/blog")
    ResponseEntity<Long> saveBlog(@RequestBody BlogData blogData);
}
