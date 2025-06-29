package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class NotificationServiceTest {

    @Test
    public void testNotifyUserCalledWithCorrectMessage(){
        Notifier mockNotifier = mock(Notifier.class);
        NotificationService service = new NotificationService(mockNotifier);
        service.sendNotification("Server down");
        verify(mockNotifier).notifyUser("NOTIFY: Server down");
    }

    @Test
    public void testNotifyUserNotCalledWhenMessageIsEmpty(){
        Notifier mockNotifier = mock(Notifier.class);
        NotificationService service = new NotificationService(mockNotifier);
        service.sendNotification("");
        verify(mockNotifier, never()).notifyUser(anyString());
    }
}