package com.ajris.site.client;

import com.ajris.site.model.Beer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("site-backend-service")
public interface BackendClient {
    @GetMapping("/api/blog")
    Resources<Beer> getSth();
}
