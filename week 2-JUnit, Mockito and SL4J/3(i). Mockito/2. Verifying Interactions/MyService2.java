package com.example;

public class MyService2{
    private final ExternalApi2 api;
    public MyService2(ExternalApi2 api) {
        this.api = api;
    }
    public String fetchData() {
        return api.getData();
    }
}