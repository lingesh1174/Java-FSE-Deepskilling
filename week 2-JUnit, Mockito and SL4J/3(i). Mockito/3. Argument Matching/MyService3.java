package com.example;

public class MyService3{
    private final ExternalApi3 api;
    public MyService3(ExternalApi3 api){
        this.api = api;
    }
    public void processAndSend(String input){
        String processed = input.trim().toUpperCase();
        api.sendData(processed);
    }
}