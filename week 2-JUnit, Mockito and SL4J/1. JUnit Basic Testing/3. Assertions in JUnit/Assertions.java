package com.example;

import java.util.Objects;

public class Assertions {
    public int sum(int a, int b){
        return a + b;
    }
    public boolean isPositive(int number){
        return number > 0;
    }
    public boolean isNull(Object obj){
        return obj == null;
    }
    public boolean isNotNull(Object obj){
        return obj != null;
    }
    public int[] getNumbers(){
        return new int[] {1, 2, 3};
    }
    public Object getSameReference(Object obj){
        return obj;
    }
    public void riskyMethod(){
        throw new IllegalStateException("Something went wrong");
    }
}