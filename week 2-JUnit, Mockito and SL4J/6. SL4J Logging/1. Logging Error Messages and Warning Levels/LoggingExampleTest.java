package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExampleTest {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExampleTest.class);

    public static void main(String[] args) {
        logger.info("Application started");

        int a = 5;
        int b = 0;

        try {
            logger.debug("Attempting division: {}/{}", a, b);
            int result = a / b;
            logger.info("Result: {}", result);
        } catch (ArithmeticException e) {
            logger.error("Error occurred during division", e);
        }

        logger.info("Application finished");
    }
}