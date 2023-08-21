package com.franbuss.ProjectBank.Services.serviceImpl;

import com.franbuss.ProjectBank.configurations.JwtTokenProvider;
import com.franbuss.ProjectBank.dto.request.LoginRequestDTO;
import com.franbuss.ProjectBank.dto.request.UserRegisterRequestDTO;
import com.franbuss.ProjectBank.dto.response.UserResponseDTO;
import com.franbuss.ProjectBank.models.User;
import com.franbuss.ProjectBank.repositories.UserRepository;
import com.franbuss.ProjectBank.services.serviceImpl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserRepository userRepositoryMock;
    @Mock
    private AuthenticationManager authenticationManagerMock;
    @Mock
    private PasswordEncoder passwordEncoderMock;
    @Mock
    private JwtTokenProvider jwtTokenProviderMock;
    @Mock
    private ModelMapper modelMapperMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        //Simular modelMapper
        when(modelMapperMock.map(any(UserRegisterRequestDTO.class), eq(User.class))).thenAnswer(invocation -> {
           UserRegisterRequestDTO dto = invocation.getArgument(0);
           User user = new User();
           user.setEmail(dto.getEmail());
           user.setName(dto.getName());
           user.setUsername(dto.getUsername());
           user.setDni(dto.getDni());
           user.setPassword(dto.getPassword());
           return user;
        });

        when(modelMapperMock.map(any(User.class), eq(UserResponseDTO.class))).thenAnswer(invocation -> {
            User user = invocation.getArgument(0);
            UserResponseDTO dto = new UserResponseDTO();
            dto.setEmail(user.getEmail());
            dto.setName(user.getName());
            dto.setUsername(user.getUsername());
            return dto;
        });

    }

    @Test
    @DisplayName("Test creacion user con email no registrado")
    void testCreateUser_Success() throws Exception {

        //Preparar datos
        UserRegisterRequestDTO requestDTO = new UserRegisterRequestDTO();
        requestDTO.setDni("40456789");
        requestDTO.setEmail("pruebamail@gmail.com");
        requestDTO.setName("pruebaNombre");
        requestDTO.setUsername("pruebaUsername");
        requestDTO.setPassword("123456Ep");

        when(userRepositoryMock.findByUsernameOrEmail(requestDTO.getUsername(), requestDTO.getEmail())).thenReturn(Optional.empty());

        when(userRepositoryMock.save(any(User.class))).thenAnswer(invocation -> {
            User user = invocation.getArgument(0);
            user.setId(1L);
            return user;
        });

        //simular passwordEncoder
        when(passwordEncoderMock.encode(requestDTO.getPassword())).thenReturn("hashed password");

        //Llamar al metodo createUser
        UserResponseDTO responseDTO = userService.createUser(requestDTO);

        //Asserts
        assertNotNull(responseDTO);
        assertEquals("pruebamail@gmail.com", responseDTO.getEmail(), "EL mail es incorrecto");
        assertEquals("pruebaUsername", responseDTO.getUsername(), "el username es incorrecto");

    }
    @Test
    void login() {

    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void list() {
    }
}