package com.franbuss.ProjectBank.services.serviceImpl;

import com.franbuss.ProjectBank.dto.request.UserLoginRequestDTO;
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
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final OfficesRepository officesRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, OfficesRepository officesRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.officesRepository = officesRepository;
        this.modelMapper = modelMapper;
    }

//    @Override
//    public UserResponseDTO createUser(UserRegisterRequestDTO userRegisterRequestDTO) throws Exception{
//        Optional<User> user = userRepository.findByDni(userRegisterRequestDTO.getDni());
//        if (user.isPresent()) {
//            throw new Exception("User already exists");
//        }
//        User userMapped = modelMapper.map(userRegisterRequestDTO, User.class);
//
//        userMapped.setRol(Rol.CLIENTE);
//
//        User saveUser = userRepository.save(userMapped);
//        return modelMapper.map(saveUser, UserResponseDTO.class);
//    }

    // REGISTER WITH TOKEN
    public UserResponseDTO registerUser(UserRegisterRequestDTO userRegister) throws Exception {
        Optional<User> optionalUser = userRepository.findByEmail(userRegister.getEmail());

        if (optionalUser.isPresent()){
            throw new Exception("Login already exist!!");
        }

        User user = modelMapper.map(userRegister, User.class);

        User  savedUser = userRepository.save(user);

        return modelMapper.map(savedUser, UserResponseDTO.class);

    }

    //LOGIN WITH TOKEN

    public UserResponseDTO loginUser(UserLoginRequestDTO userLogin) throws Exception {
        Optional<User> optionalUser = userRepository.findByEmail(userLogin.getEmail());

        if (optionalUser.isPresent()){
            User user = optionalUser.get();

            if (user.getPassword().equals(user.getPassword())){
                return modelMapper.map(user, UserResponseDTO.class);
            }
            throw new Exception("Invalid password");
        }

        throw new Exception("Invalid user");
    }

    @Override
    public UserResponseDTO createEmployee(UserRegisterRequestDTO userRegisterRequestDTO, Long id) throws Exception {
        Optional<User> user = userRepository.findByDni(userRegisterRequestDTO.getDni());
        Optional<Offices> office = officesRepository.findById(id);

        if (user.isPresent()) {
            throw new Exception("User already exists");
        }

        if (!office.isPresent()){
            throw new Exception("The office not exist!");
        }

        Offices optionalOffice = office.get();

        User userMapped = modelMapper.map(userRegisterRequestDTO, User.class);
        userMapped.setRol(Rol.EMPLEADO);
        userMapped.setOffices(optionalOffice);

        for (User users : optionalOffice.getUsers()) {
            if (users.equals(userMapped)) {
                throw new Exception("The user is already in the office!");
            }
        }

        optionalOffice.getUsers().add(userMapped);
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
    public void deleteUser(Long id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User userToBeDelete = user.get();
            if (userToBeDelete.getCheckOut()){
                userRepository.deleteById(id);
            }
        } else {
            throw new Exception("User cannot be deleted");
        }
    }

    @Override
    public void checkOut(Long id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User optionalUser = user.get();
            optionalUser.setCheckOut(true);
            userRepository.save(optionalUser);
        } else {
            throw new Exception("User not found");
        }
    }

    @Override
    public List<UserResponseDTO> list() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(user -> modelMapper.map(user, UserResponseDTO.class))
                .collect(Collectors.toList());
    }


    @Override
    public List<UserResponseDTO> getUsersByOffice(Long officeId){
        List<User> employeesList = userRepository.findUsersByOfficeId(officeId);
        return employeesList.stream()
                .map(user -> modelMapper.map(user, UserResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO findByEmail(String email) throws Exception {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            User optionalUser = user.get();
            return modelMapper.map(optionalUser, UserResponseDTO.class);
        } else {
            throw new Exception ("Could not find user by email " + email);
        }
    }
}
