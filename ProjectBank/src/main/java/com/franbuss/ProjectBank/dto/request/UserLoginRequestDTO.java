package com.franbuss.ProjectBank.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserLoginRequestDTO{

    @NotBlank(message = "Please enter email address")
    @Email(message = "The email is not a valid email address")
    private String email;

    @NotBlank(message = "Please enter password")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,16}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, and one digit. " +
                    "It should be 8 to 16 characters long.")
    private String password;

    public UserLoginRequestDTO() {
    }

    public UserLoginRequestDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
