package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import static org.mockito.Mockito.*;

public class MyServiceTest3 {

    @Test
    public void testSendDataCalledWithProcessedArgument() {
        ExternalApi3 mockApi = mock(ExternalApi3.class);
        MyService3 service = new MyService3(mockApi);
        service.processAndSend(" hello ");
        verify(mockApi).sendData(ArgumentMatchers.eq("HELLO"));
    }
}