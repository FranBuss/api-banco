package com.franbuss.ProjectBank.controllers;

import com.franbuss.ProjectBank.configurations.UserAuthenticationProvider;
import com.franbuss.ProjectBank.dto.request.UserLoginRequestDTO;
import com.franbuss.ProjectBank.dto.request.UserRegisterRequestDTO;
import com.franbuss.ProjectBank.dto.response.UserResponseDTO;
import com.franbuss.ProjectBank.services.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class AuthController {

    private UserService userService;
    private UserAuthenticationProvider userAuthenticationProvider;

    @Autowired
    public AuthController(UserService userService, UserAuthenticationProvider userAuthenticationProvider) {
        this.userService = userService;
        this.userAuthenticationProvider = userAuthenticationProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody @Valid UserLoginRequestDTO userLoginRequestDTO) throws Exception {
        UserResponseDTO userResponseDTO = userService.loginUser(userLoginRequestDTO);
        userResponseDTO.setToken(userAuthenticationProvider.createToken(userResponseDTO));
        return ResponseEntity.ok(userResponseDTO);
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody @Valid UserRegisterRequestDTO userRegisterRequestDTO) throws Exception {
        UserResponseDTO createdUser = userService.registerUser(userRegisterRequestDTO);
        createdUser.setToken(userAuthenticationProvider.createToken(createdUser));
        return ResponseEntity.created(URI.create("/users/" + createdUser.getEmail())).body(createdUser);
    }

}
