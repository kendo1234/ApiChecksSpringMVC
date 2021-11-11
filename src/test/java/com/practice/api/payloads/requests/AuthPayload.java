package com.practice.api.payloads.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthPayload {

    @JsonProperty
    private String username;

    @JsonProperty
    private String password;

    public AuthPayload(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public static class AuthPayloadBuilder {

        private String username;
        private String password;

        public AuthPayloadBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public AuthPayloadBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public AuthPayload build() {
            return new AuthPayload(username, password);
        }
    }
}
