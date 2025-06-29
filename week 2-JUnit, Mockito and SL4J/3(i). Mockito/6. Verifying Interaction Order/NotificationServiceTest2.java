package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import static org.mockito.Mockito.*;

public class NotificationServiceTest2{

    @Test
    public void testInteractionOrder(){
        NotificationService2 mockService = mock(NotificationService2.class);
        mockService.connect();
        mockService.send("Hello!");
        mockService.disconnect();

        InOrder inOrder = inOrder(mockService);
        inOrder.verify(mockService).connect();
        inOrder.verify(mockService).send("Hello!");
        inOrder.verify(mockService).disconnect();
    }
}