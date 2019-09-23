package com.ajris.site.controller;

import com.ajris.site.client.BackendClient;
import com.ajris.site.model.BlogInformation;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiGatewayController {
    private final BackendClient backendClient;

    public ApiGatewayController(BackendClient backendClient) {
        this.backendClient = backendClient;
    }

    @GetMapping("/blogs")
    @CrossOrigin
    public List<BlogInformation> goodBeers(Principal user) {
        System.out.println("WELCOME USER: " + user);
//        return new ArrayList<>();
        return backendClient.getBlogPosts().getBody();
    }

    @GetMapping("/att")
    @CrossOrigin
    public String anything(@AuthenticationPrincipal OidcUser user) {
        System.out.println(user.getEmail());
        return user.getAttributes().toString();
    }
}
