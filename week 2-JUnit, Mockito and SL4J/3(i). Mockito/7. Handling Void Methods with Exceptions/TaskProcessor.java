package com.example;

public class TaskProcessor{
    private final LoggerService logger;
    public TaskProcessor(LoggerService logger){
        this.logger = logger;
    }

    public void process(){
        logger.log("Task started");
    }
}