package com.example;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
public class OrderedTests{

    @Test
    @Order(1)
    void testLogin(){
        System.out.println("Test: User logs in");
        assertTrue(true);
    }

    @Test
    @Order(2)
    void testViewDashboard(){
        System.out.println("Test: View dashboard");
        assertTrue(true);
    }

    @Test
    @Order(3)
    void testLogout(){
        System.out.println("Test: User logs out");
        assertTrue(true);
    }
}
