package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class MyServiceTest2 {

    @Test
    public void testVerifyInteraction() {
        ExternalApi2 mockApi = Mockito.mock(ExternalApi2.class);
        MyService2 service = new MyService2(mockApi);
        service.fetchData();
        verify(mockApi).getData();
    }
}