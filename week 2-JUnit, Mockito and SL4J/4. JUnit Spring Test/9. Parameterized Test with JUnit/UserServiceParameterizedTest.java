package com.example.service;

import com.example.service.UserService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceParameterizedTest {
    private final UserService userService = new UserService();

    @ParameterizedTest
    @CsvSource({
        "Alice, true",
        "Bob, true",
        "'', false",
        "'   ', false",
        "123, false",
        "Lingesh, true"
    })
    void testIsValidUserName(String name, boolean expected) {
        boolean actual = userService.isValidUserName(name);
        assertEquals(expected, actual);
    }
}