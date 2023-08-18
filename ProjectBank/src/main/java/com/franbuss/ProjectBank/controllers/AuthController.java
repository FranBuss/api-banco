package com.franbuss.ProjectBank.controllers;

import com.franbuss.ProjectBank.dto.request.LoginRequestDTO;
import com.franbuss.ProjectBank.dto.response.JWTAuthResponse;
import com.franbuss.ProjectBank.services.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<JWTAuthResponse> authenticate(@RequestBody LoginRequestDTO loginRequestDTO){
        String token = userService.login(loginRequestDTO);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }

}
