package com.keyin.sprint.dto;

public class UserToken {
    private String username;
    private String token;

    public UserToken(String username, String token) {
        this.username = username;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public String getToken() {
        return token;
    }
}
