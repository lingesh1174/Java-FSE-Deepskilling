package com.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class Calculator2Test{
    private Calculator2 calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator2();
        System.out.println("➡️ Before each test");
    }

    @AfterEach
    void tearDown(){
        calculator.clearMemory();
        System.out.println("↩️ After each test");
    }

    @Test
    void testAddition(){
        int result = calculator.add(10, 5);
        assertEquals(15, result, "10 + 5 should be 15");
    }

    @Test
    void testSubtraction(){
        int result = calculator.subtract(10, 5);
        assertEquals(5, result, "10 - 5 should be 5");
    }
}
