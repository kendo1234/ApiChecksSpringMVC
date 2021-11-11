package com.practice.api.requests;

import com.practice.api.payloads.requests.AuthPayload;
import com.practice.api.payloads.responses.AuthResponse;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class Auth {

    private static RestTemplate restTemplate = new RestTemplate();

    public static ResponseEntity<AuthResponse> postAuth(AuthPayload payload) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<AuthPayload> httpEntity = new HttpEntity<>(payload, requestHeaders);

        return restTemplate.exchange("http://localhost:3001/auth", HttpMethod.POST, httpEntity, AuthResponse.class);
    }
}
