package com.ajris.site.client;

import com.ajris.site.model.BlogInformation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("backend-service")
public interface BackendClient {
    @GetMapping("/api/blog")
    ResponseEntity<List<BlogInformation>> getBlogs();
}
