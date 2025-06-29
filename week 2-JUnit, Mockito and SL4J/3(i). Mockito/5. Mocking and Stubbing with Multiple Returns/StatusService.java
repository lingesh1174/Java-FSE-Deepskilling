package com.example;

public class StatusService{
    private final ExternalApi5 api;

    public StatusService(ExternalApi5 api){
        this.api = api;
    }

    public String[] checkStatusMultipleTimes(){
        String[] results = new String[3];
        results[0] = api.getStatus();
        results[1] = api.getStatus();
        results[2] = api.getStatus();
        return results;
    }
}