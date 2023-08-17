package com.franbuss.ProjectBank.dto.request;


import javax.validation.constraints.*;

public class UserRegisterRequestDTO {

    @NotBlank(message = "Please enter email address")
    @Email(message = "The email is not a valid email address")
    private String email;

    @NotBlank(message = "Please enter your name")
    private String name;

    @NotBlank(message = "Please enter your last name")
    private String username;

    @NotBlank(message = "The dni is required")
    private String dni;

    @NotBlank(message = "Please enter password")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,16}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, and one digit. " +
                    "It should be 8 to 16 characters long.")
    private String password;

    public UserRegisterRequestDTO() {
    }

    public UserRegisterRequestDTO(String email, String name, String username, String dni, String password) {
        this.email = email;
        this.name = name;
        this.username = username;
        this.dni = dni;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

}
