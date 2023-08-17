package com.franbuss.ProjectBank.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class LoginRequestDTO {

    @NotBlank
    private String usernameOrEmail;

    @NotBlank(message = "Please enter password")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,16}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, and one digit. " +
                    "It should be 8 to 16 characters long.")
    private String password;

    public LoginRequestDTO() {
    }

    public LoginRequestDTO(String usernameOrEmail, String password) {
        this.usernameOrEmail = usernameOrEmail;
        this.password = password;
    }

    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
