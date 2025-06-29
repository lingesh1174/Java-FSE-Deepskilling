package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest{

    @Test
    void testExceptionIsThrown(){
        ExceptionThrower thrower = new ExceptionThrower();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException(true);
        });
        assertEquals("Expected exception thrown", exception.getMessage());
    }

    @Test
    void testNoExceptionIsThrown(){
        ExceptionThrower thrower = new ExceptionThrower();
        assertDoesNotThrow(() -> {
            thrower.throwException(false);
        });
    }
}