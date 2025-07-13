package com.cognizant.jwt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Base64;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("START - /authenticate");
        LOGGER.debug("Authorization header: {}", authHeader);

        String user = getUser(authHeader); 
        LOGGER.debug("Decoded username: {}", user);

        Map<String, String> map = new HashMap<>();
        map.put("token", "");
        LOGGER.info("END - /authenticate");
        return map;
    }
    
    private String getUser(String authHeader) {
        LOGGER.debug("Start - getUser()");
        String encodedCredentials = authHeader.substring("Basic ".length());
        LOGGER.debug("Encoded credentials: {}", encodedCredentials);

        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String decodedString = new String(decodedBytes);
        LOGGER.debug("Decoded credentials: {}", decodedString);

        String username = decodedString.split(":")[0];
        LOGGER.debug("Extracted username: {}", username);
        LOGGER.debug("End - getUser()");
        return username;
    }
}