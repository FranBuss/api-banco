package com.franbuss.ProjectBank.dto.response;

public class JWTAuthResponse {

    private String token;

    public JWTAuthResponse() {
    }

    public JWTAuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
