package com.franbuss.ProjectBank.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserUpdateRequestDTO {

    @NotBlank(message = "Please enter your name")
    private String name;
    @NotBlank(message = "Please enter your last name")
    private String lastName;
    @NotBlank(message = "Please enter password")
    @Size(min = 8, max = 16, message = "The password must be 8 characters long")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,16}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, and one digit. " +
                    "It should be 8 to 16 characters long.")
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
