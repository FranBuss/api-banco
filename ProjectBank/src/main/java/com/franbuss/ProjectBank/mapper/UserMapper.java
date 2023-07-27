package com.franbuss.ProjectBank.mapper;

import com.franbuss.ProjectBank.dto.request.UserRegisterRequestDTO;
import com.franbuss.ProjectBank.dto.response.UserResponseDTO;
import com.franbuss.ProjectBank.models.User;
import org.mapstruct.Mapper;


@Mapper
public interface UserMapper {

    User userRegisterRequestDTOToUser (UserRegisterRequestDTO userRegisterRequest);

    UserResponseDTO userToUserResponseDTO (User user);

}
