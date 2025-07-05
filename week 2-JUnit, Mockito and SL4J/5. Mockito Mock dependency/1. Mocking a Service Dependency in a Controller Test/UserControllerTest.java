package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void testGetUserById_ReturnsUser() {
        User mockUser = new User();
        mockUser.setId(1L);
        mockUser.setName("Alice");
        when(userService.getUserById(1L)).thenReturn(mockUser);
        ResponseEntity<User> response = userController.getUser(1L);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Alice", response.getBody().getName());
    }
}