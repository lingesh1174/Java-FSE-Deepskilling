package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {
    Assertions assertions = new Assertions();

    @Test
    void testSum(){
        assertEquals(10, assertions.sum(4, 6));
    }

    @Test
    void testIsPositive(){
        assertTrue(assertions.isPositive(5));
        assertFalse(assertions.isPositive(-2));
    }

    @Test
    void testNullCheck(){
        assertTrue(assertions.isNull(null));
        assertFalse(assertions.isNull("Hello"));
        assertFalse(assertions.isNotNull(null));
        assertTrue(assertions.isNotNull("World"));
    }

    @Test
    void testArrayEquals(){
        assertArrayEquals(new int[]{1, 2, 3}, assertions.getNumbers());
    }

    @Test
    void testSameReference(){
        Object obj = new Object();
        assertSame(obj, assertions.getSameReference(obj));
        assertNotSame(obj, new Object());
    }

    @Test
    void testExceptionThrown(){
        Exception ex = assertThrows(IllegalStateException.class, () -> {
            assertions.riskyMethod();
        });
        assertEquals("Something went wrong", ex.getMessage());
    }
}