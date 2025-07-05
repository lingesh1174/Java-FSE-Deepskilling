package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiAppenderLogger {
    private static final Logger logger = LoggerFactory.getLogger(MultiAppenderLogger.class);
    public static void main(String[] args) {
        logger.info("Application started");
        logger.warn("This is a warning message");
        logger.error("This is an error message");
        try {
            int result = 10 / 0;
        }
        catch (ArithmeticException e) {
            logger.error("Exception occurred: {}", e.toString());
        }
        logger.info("Application ended");
    }
}