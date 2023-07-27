package com.franbuss.ProjectBank.services.service;

import com.franbuss.ProjectBank.dto.request.UserRegisterRequestDTO;
import com.franbuss.ProjectBank.dto.request.UserUpdateRequestDTO;
import com.franbuss.ProjectBank.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {
    //Crear usuario
    UserResponseDTO createUser(UserRegisterRequestDTO userRegisterRequestDTO) throws Exception;

    //Modificar usuario
    UserResponseDTO updateUser(Long id, UserUpdateRequestDTO userUpdateRequestDTO) throws Exception;

    //Eliminar usuario
    void deleteUser(Long id);

    //Listar usuarios
    List<UserResponseDTO> list();

    //Obtener usuario por email
    UserResponseDTO findByEmail(String email);



}
