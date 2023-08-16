package com.franbuss.ProjectBank.configurations;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.franbuss.ProjectBank.dto.request.UserRegisterRequestDTO;
import com.franbuss.ProjectBank.dto.response.UserResponseDTO;
import com.franbuss.ProjectBank.services.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;

@Component
public class UserAuthenticationProvider {

    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKey;

    private UserService userService;

    public UserAuthenticationProvider(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    protected void init(){
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(UserResponseDTO userResponseDTO){

        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000);

        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        return JWT.create()
                .withIssuer(userResponseDTO.getEmail())
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .withClaim("name" , userResponseDTO.getName())
                .withClaim("lastName", userResponseDTO.getLastName())
                .sign(algorithm);

    }

    public Authentication validateToken(String token) {

        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        JWTVerifier verifier = JWT.require(algorithm).build();

        DecodedJWT decoded = verifier.verify(token);

        UserRegisterRequestDTO user = new UserRegisterRequestDTO();

        user.setName(decoded.getClaim("name").asString());
        user.setLastName(decoded.getClaim("lastName").asString());

        return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());

    }


}
