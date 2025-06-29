package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.Optional;

public class UserServiceTest{

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    public UserServiceTest(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUserById(){
        User mockUser = new User();
        mockUser.setId(1L);
        mockUser.setName("Lingesh");

        when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));
        User result = userService.getUserById(1L);
        assertNotNull(result);
        assertEquals("Lingesh", result.getName());
        assertEquals(1L, result.getId());
    }
}