package com.ajris.site.client;

import com.ajris.site.model.Blog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("backend-service")
public interface BackendClient {
    @GetMapping("/api/blog")
    Resources<Blog> getBlogs();
}
