package com.franbuss.ProjectBank.services.service;

import com.franbuss.ProjectBank.dto.request.UserRegisterRequestDTO;
import com.franbuss.ProjectBank.dto.request.UserUpdateRequestDTO;
import com.franbuss.ProjectBank.dto.response.UserResponseDTO;
import com.franbuss.ProjectBank.models.User;

import java.util.List;

public interface UserService {
    //Crear usuario
    UserResponseDTO createUser(UserRegisterRequestDTO userRegisterRequestDTO) throws Exception;

    //Modificar usuario
    UserResponseDTO updateUser(Long id, UserUpdateRequestDTO userUpdateRequestDTO) throws Exception;

    //Eliminar usuario
    void deleteUser(Long id) throws Exception;

    //Listar usuarios
    List<UserResponseDTO> list();

    void checkOut(Long id) throws Exception;

    UserResponseDTO createEmployee(UserRegisterRequestDTO userRegisterRequestDTO, Long id) throws Exception;

    public List<UserResponseDTO> getUsersByOffice(Long officeId);

}
