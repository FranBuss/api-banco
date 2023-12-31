package com.franbuss.ProjectBank.dto.response;

import javax.validation.constraints.NotBlank;

public class UserResponseDTO {

    @NotBlank
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank
    private String phoneNumber;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
