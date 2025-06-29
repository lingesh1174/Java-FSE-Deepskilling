package com.example;

public class ArithmeticOperations {
    public int add(int a, int b){
        return a + b;
    }
    public int multiply(int a, int b){
        return a * b;
    }
    public boolean isEven(int number){
        return number % 2 == 0;
    }
    public int divide(int a, int b){
        if (b == 0) throw new IllegalArgumentException("Division by zero");
        return a / b;
    }
}