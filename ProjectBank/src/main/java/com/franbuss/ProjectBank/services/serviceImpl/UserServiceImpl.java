package com.franbuss.ProjectBank.services.serviceImpl;

import com.franbuss.ProjectBank.configurations.JwtTokenProvider;
import com.franbuss.ProjectBank.dto.request.LoginRequestDTO;
import com.franbuss.ProjectBank.dto.request.UserRegisterRequestDTO;
import com.franbuss.ProjectBank.dto.request.UserUpdateRequestDTO;
import com.franbuss.ProjectBank.dto.response.UserResponseDTO;
import com.franbuss.ProjectBank.enums.Rol;
import com.franbuss.ProjectBank.models.Offices;
import com.franbuss.ProjectBank.models.User;
import com.franbuss.ProjectBank.repositories.OfficesRepository;
import com.franbuss.ProjectBank.repositories.UserRepository;
import com.franbuss.ProjectBank.services.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper,
                           AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserResponseDTO createUser(UserRegisterRequestDTO userRegisterRequestDTO) throws Exception{
        Optional<User> user = userRepository.findByDniOrEmail(userRegisterRequestDTO.getDni(), userRegisterRequestDTO.getEmail());
        if (user.isPresent()) {
            throw new Exception("User already exists");
        }
        User userMapped = modelMapper.map(userRegisterRequestDTO, User.class);

        userMapped.setPassword(passwordEncoder.encode(userRegisterRequestDTO.getPassword()));

        User saveUser = userRepository.save(userMapped);
        return modelMapper.map(saveUser, UserResponseDTO.class);
    }

    @Override
    public String login(LoginRequestDTO loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }


    @Override
    public UserResponseDTO updateUser(Long id, UserUpdateRequestDTO userUpdateRequestDTO) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User optionalUser = user.get();
            if (userUpdateRequestDTO.getName() != null && userUpdateRequestDTO.getName().isEmpty()){
                optionalUser.setName(userUpdateRequestDTO.getName());
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
    public void deleteUser(Long id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User userToBeDelete = user.get();
            userRepository.deleteById(userToBeDelete.getId());
        } else {
            throw new Exception("User cannot be deleted");
        }
    }



    @Override
    public List<UserResponseDTO> list() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(user -> modelMapper.map(user, UserResponseDTO.class))
                .collect(Collectors.toList());
    }


//    @Override
//    public List<UserResponseDTO> getUsersByOffice(Long officeId){
//        List<User> employeesList = userRepository.findUsersByOfficeId(officeId);
//        return employeesList.stream()
//                .map(user -> modelMapper.map(user, UserResponseDTO.class))
//                .collect(Collectors.toList());
//    }

    //    @Override
//    public UserResponseDTO createEmployee(UserRegisterRequestDTO userRegisterRequestDTO, Long id) throws Exception {
//        Optional<User> user = userRepository.findByDniOrEmail(userRegisterRequestDTO.getDni(), userRegisterRequestDTO.getEmail());
////        Optional<Offices> office = officesRepository.findById(id);
//
//        if (user.isPresent()) {
//            throw new Exception("User already exists");
//        }
//
////        if (!office.isPresent()){
////            throw new Exception("The office not exist!");
////        }
////
////        Offices optionalOffice = office.get();
//
//        User userMapped = modelMapper.map(userRegisterRequestDTO, User.class);
//
////        for (User users : optionalOffice.getUsers()) {
////            if (users.equals(userMapped)) {
////                throw new Exception("The user is already in the office!");
////            }
////        }
////
////        optionalOffice.getUsers().add(userMapped);
//        User saveUser = userRepository.save(userMapped);
//        return modelMapper.map(saveUser, UserResponseDTO.class);
//    }


}
