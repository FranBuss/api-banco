package com.franbuss.ProjectBank.controllers;

import com.franbuss.ProjectBank.dto.request.UserRegisterRequestDTO;
import com.franbuss.ProjectBank.dto.request.UserUpdateRequestDTO;
import com.franbuss.ProjectBank.dto.response.UserResponseDTO;
import com.franbuss.ProjectBank.models.User;
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
    public ResponseEntity<String> register(@Valid @RequestBody UserRegisterRequestDTO userRegisterRequestDTO){
        UserResponseDTO createdUser;
        try {
            createdUser = userService.createUser(userRegisterRequestDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdUser.toString(), HttpStatus.CREATED);

    }

//    @PostMapping("/registerEmployee")
//    public ResponseEntity<?> employeeRegister(@Valid @RequestBody UserRegisterRequestDTO userRegisterRequestDTO, @RequestParam Long officeId){
//        UserResponseDTO createdUser;
//        try {
//            createdUser = userService.createEmployee(userRegisterRequestDTO, officeId);
//        } catch (Exception e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
//    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id,@Valid @RequestBody UserUpdateRequestDTO userUpdateRequestDTO){
        UserResponseDTO updatedUser;
        try {
            updatedUser = userService.updateUser(id, userUpdateRequestDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(updatedUser, HttpStatus.ACCEPTED);
    }

//    @GetMapping("/listEmployees/{office_id}")
//    public List<UserResponseDTO> listEmployees(@PathVariable("office_id") Long id){
//        return userService.getUsersByOffice(id);
//    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        try {
            userService.deleteUser(id);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }


    @GetMapping("/list")
    public List<UserResponseDTO> list(){
        return userService.list();
    }

}
