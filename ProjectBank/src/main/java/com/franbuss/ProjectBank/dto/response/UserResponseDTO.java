package com.franbuss.ProjectBank.dto.response;

import javax.validation.constraints.NotBlank;

public class UserResponseDTO {

    @NotBlank
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private String username;


    public UserResponseDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserResponseDTO{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
