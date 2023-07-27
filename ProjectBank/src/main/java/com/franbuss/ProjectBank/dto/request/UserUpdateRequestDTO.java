package com.franbuss.ProjectBank.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserUpdateRequestDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank
    @Size(min = 8, max = 16)
    private String password;

    public UserUpdateRequestDTO() {
    }

    public UserUpdateRequestDTO(String name, String lastName, String password) {
        this.name = name;
        this.lastName = lastName;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
