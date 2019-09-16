package com.ajris.site.client;

import com.ajris.site.model.BlogInformation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("backend-service")
public interface BackendClient {
    @GetMapping("/api/blog")
    ResponseEntity<List<BlogInformation>> getBlogPosts();

    @GetMapping("/api/project")
    ResponseEntity<List<BlogInformation>> getProjects();

    @GetMapping("/api/technology")
    ResponseEntity<List<BlogInformation>> getTechnologies();

    @PostMapping("/api/blog")
    ResponseEntity<List<BlogInformation>> saveBlog(@RequestBody BlogInformation blogInformation);
}
