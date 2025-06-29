package com.example;

public class NotificationService{
    private final Notifier notifier;
    public NotificationService(Notifier notifier){
        this.notifier = notifier;
    }
    public void sendNotification(String userMessage){
        if (userMessage != null && !userMessage.isEmpty()){
            notifier.notifyUser("NOTIFY: " + userMessage);
        }
    }
}