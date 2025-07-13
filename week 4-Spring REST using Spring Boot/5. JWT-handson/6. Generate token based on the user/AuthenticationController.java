package com.cognizant.jwt.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Value("${jwt.secret}")
    private String secret;

    private Key key;

    @PostConstruct
    public void init() {
        key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        LOGGER.debug("JWT secret key initialized");
    }

    @PostMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("START - /authenticate");
        LOGGER.debug("Authorization header: {}", authHeader);

        String user = getUser(authHeader);
        LOGGER.debug("Decoded username: {}", user);

        String token = generateJwt(user);

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        LOGGER.info("END - /authenticate");
        return response;
    }

    private String getUser(String authHeader) {
        LOGGER.debug("Start - getUser()");
        String encodedCredentials = authHeader.substring(6);
        byte[] decodedBytes = java.util.Base64.getDecoder().decode(encodedCredentials);
        String decodedCredentials = new String(decodedBytes, StandardCharsets.UTF_8);
        String username = decodedCredentials.split(":")[0];
        LOGGER.debug("Extracted username: {}", username);
        return username;
    }

    private String generateJwt(String user) {
        LOGGER.debug("Start - generateJwt()");
        JwtBuilder builder = Jwts.builder()
                .setSubject(user)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + 1200000))
                .signWith(key, SignatureAlgorithm.HS256);

        String token = builder.compact();
        LOGGER.debug("Generated token: {}", token);
        return token;
    }
}