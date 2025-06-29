package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class TaskProcessorTest{

    @Test
    public void testVoidMethodThrowsException(){
        LoggerService logger = mock(LoggerService.class);
        doThrow(new RuntimeException("Logging failed"))
            .when(logger).log("Task started");

        TaskProcessor processor = new TaskProcessor(logger);

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            processor.process();
        });
        assertEquals("Logging failed", ex.getMessage());
        verify(logger).log("Task started");
    }
}