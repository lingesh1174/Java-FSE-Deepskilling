package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest{

    @Test
    void testAddition(){
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(2, 3), "2 + 3 should equal 5");
    }

    @Test
    void testSubtraction(){
        Calculator calc = new Calculator();
        assertEquals(3, calc.subtract(4, 1), "4 - 1 should equal 3");
    }
}