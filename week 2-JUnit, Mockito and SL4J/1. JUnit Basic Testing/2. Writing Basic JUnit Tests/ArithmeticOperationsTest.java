package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticOperationsTest{
    ArithmeticOperations op = new ArithmeticOperations();

    @Test
    void testAddition(){
        assertEquals(7, op.add(3, 4), "3 + 4 should be 7");
    }

    @Test
    void testMultiplication(){
        assertEquals(12, op.multiply(3, 4), "3 * 4 should be 12");
    }

    @Test
    void testIsEvenTrue(){
        assertTrue(op.isEven(6), "6 should be even");
    }

    @Test
    void testIsEvenFalse(){
        assertFalse(op.isEven(5), "5 should not be even");
    }

    @Test
    void testDivide(){
        assertEquals(2, op.divide(10, 5), "10 / 5 should be 2");
    }

    @Test
    void testDivideByZero(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            op.divide(10, 0);
        });
        assertEquals("Division by zero", exception.getMessage());
    }
}