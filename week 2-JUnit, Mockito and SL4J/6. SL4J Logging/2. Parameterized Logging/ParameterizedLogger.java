package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLogger {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLogger.class);

    public static void main(String[] args) {
        String product = "Laptop";
        int quantity = 2;
        double price = 799.49;

        logger.info("Order placed: {} x {} @ ${} each", quantity, product, price);
        logger.debug("Debug info: product={}, quantity={}, price={}", product, quantity, price);
        logger.warn("Low stock alert for product: {}", product);
    }
}