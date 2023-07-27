package com.franbuss.ProjectBank.services.serviceImpl;

import com.franbuss.ProjectBank.dto.request.UserRegisterRequestDTO;
import com.franbuss.ProjectBank.dto.request.UserUpdateRequestDTO;
import com.franbuss.ProjectBank.dto.response.UserResponseDTO;
import com.franbuss.ProjectBank.mapper.UserMapper;
import com.franbuss.ProjectBank.models.User;
import com.franbuss.ProjectBank.repositories.UserRepository;
import com.franbuss.ProjectBank.services.service.UserService;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;
    private final UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserResponseDTO createUser(UserRegisterRequestDTO userRegisterRequestDTO) throws Exception {
        Optional<User> user = userRepository.findByEmail(userRegisterRequestDTO.getEmail());
        if (user.isPresent()) {
            throw new Exception("User already exists");
        }
        User userMapped = modelMapper.map(userRegisterRequestDTO, User.class);
        User saveUser = userRepository.save(userMapped);
        return modelMapper.map(saveUser, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserUpdateRequestDTO userUpdateRequestDTO) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User optionalUser = user.get();
            if (userUpdateRequestDTO.getName() != null && userUpdateRequestDTO.getName().isEmpty()){
                optionalUser.setName(userUpdateRequestDTO.getName());
            }
            if (userUpdateRequestDTO.getLastName() != null && userUpdateRequestDTO.getLastName().isEmpty()){
                optionalUser.setLastName(userUpdateRequestDTO.getLastName());
            }
            if (userUpdateRequestDTO.getPassword() != null && userUpdateRequestDTO.getPassword().isEmpty()){
                optionalUser.setPassword(userUpdateRequestDTO.getPassword());
            }
            userRepository.save(optionalUser);
            return modelMapper.map(optionalUser, UserResponseDTO.class);
        } else {
            throw new Exception("User not found");
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserResponseDTO> list() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(user -> modelMapper.map(user, UserResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO findByEmail(String email) {
        return null;
    }
}
