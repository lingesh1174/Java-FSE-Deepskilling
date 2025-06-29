package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StatusServiceTest{

    @Test
    public void testMultipleStatusReturns(){
        ExternalApi5 mockApi = mock(ExternalApi5.class);
        when(mockApi.getStatus())
            .thenReturn("OK")
            .thenReturn("WARN")
            .thenReturn("ERROR");

        StatusService service = new StatusService(mockApi);
        String[] statuses = service.checkStatusMultipleTimes();
        assertArrayEquals(new String[]{"OK", "WARN", "ERROR"}, statuses);
        verify(mockApi, times(3)).getStatus();
    }
}