package com.example;

public class Service2{
    private final Repository2 repository;
    public Service2(Repository2 repository){
        this.repository = repository;
    }
    public String processData(){
        return "Processed " + repository.getData();
    }
}