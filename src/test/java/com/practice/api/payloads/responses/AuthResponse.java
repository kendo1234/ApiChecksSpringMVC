package com.practice.api.payloads.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthResponse {

    @JsonProperty
    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
