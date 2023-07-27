package com.franbuss.ProjectBank.controllers;

import com.franbuss.ProjectBank.dto.request.UserRegisterRequestDTO;
import com.franbuss.ProjectBank.dto.request.UserUpdateRequestDTO;
import com.franbuss.ProjectBank.dto.response.UserResponseDTO;
import com.franbuss.ProjectBank.services.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@Valid @RequestBody UserRegisterRequestDTO userRegisterRequestDTO){
        UserResponseDTO createdUser;
        try {
            createdUser = userService.createUser(userRegisterRequestDTO);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(createdUser);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable("id") Long id,@Valid @RequestBody UserUpdateRequestDTO userUpdateRequestDTO){
        UserResponseDTO updatedUser;
        try {
            updatedUser = userService.updateUser(id, userUpdateRequestDTO);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        try {
            userService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.OK).body("success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/list")
    public List<UserResponseDTO> list(){
        return userService.list();
    }

}
