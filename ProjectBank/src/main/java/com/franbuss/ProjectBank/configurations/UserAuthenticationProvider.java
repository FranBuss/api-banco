package com.franbuss.ProjectBank.configurations;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import com.franbuss.ProjectBank.services.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class UserAuthenticationProvider {

    private static final Logger logger = LoggerFactory.getLogger(UserAuthenticationProvider.class);

    @Value("${app.jwt-secret}")
    private String jwtSecret;

    @Value("${app-jwt-expiration-milliseconds}")
    private long jwtExpirationDate;


    public String genereateToken(Authentication authentication){
        String username = authentication.getName();

        Date currentDate = new Date();

        Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(key())
                .compact();

        return token;
    }

    private Key key(){
        return Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(jwtSecret)
        );
    }

    //devuelve el username
    public String getUserName(String token){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody();
        String username = claims.getSubject();
        return username;
    }

    //validar el token
    public boolean validateToken(String token){
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key())
                    .build()
                    .parse(token);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }

//    @PostConstruct
//    protected void init(){
//        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
//    }
//
//    public String createToken(UserResponseDTO userResponseDTO){
//
//        Date now = new Date();
//        Date validity = new Date(now.getTime() + 3600000);
//
//        Algorithm algorithm = Algorithm.HMAC256(secretKey);
//
//        return JWT.create()
//                .withIssuer(userResponseDTO.getEmail())
//                .withIssuedAt(now)
//                .withExpiresAt(validity)
//                .withClaim("name" , userResponseDTO.getName())
//                .withClaim("lastName", userResponseDTO.getLastName())
//                .sign(algorithm);
//
//    }
//
//    public Authentication validateToken(String token) {
//
//        Algorithm algorithm = Algorithm.HMAC256(secretKey);
//
//        JWTVerifier verifier = JWT.require(algorithm).build();
//
//        DecodedJWT decoded = verifier.verify(token);
//
//        UserRegisterRequestDTO user = new UserRegisterRequestDTO();
//
//        user.setName(decoded.getClaim("name").asString());
//        user.setLastName(decoded.getClaim("lastName").asString());
//
//        return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
//
//    }
//
//    public Authentication validateTokenStrongly(String token) {
//
//        Algorithm algorithm = Algorithm.HMAC256(secretKey);
//
//        JWTVerifier verifier = JWT.require(algorithm).build();
//
//        DecodedJWT decoded = verifier.verify(token);
//
//        UserResponseDTO user = userService.findByEmail(decoded.getIssuer());
//
//        return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
//
//    }


}
