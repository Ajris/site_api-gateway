package com.ajris.site.client;

import com.ajris.site.model.BlogInformation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

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
