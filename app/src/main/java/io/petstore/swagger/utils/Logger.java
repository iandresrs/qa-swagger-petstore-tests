package io.petstore.swagger.utils;

import org.slf4j.LoggerFactory;

public class Logger {

    public static void error(Class<?> clazz, String message) {
        LoggerFactory.getLogger(clazz.getName()).error(message);
    }

    public static void info(Class<?> clazz, String message) {
        LoggerFactory.getLogger(clazz.getName()).info(message);
    }
    
}
