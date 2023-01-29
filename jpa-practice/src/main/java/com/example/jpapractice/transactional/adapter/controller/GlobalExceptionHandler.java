package com.example.jpapractice.transactional.adapter.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collection;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = Logger.getLogger(GlobalExceptionHandler.class.getName());
    private static final String IN_HOUSE_PACKAGE_PREFIX = "com.example.";
    private static final Collection<String> EXCEPTION_UTIL_CLASS_NAMES = Set.of(
            org.springframework.util.Assert.class.getName(),
            java.util.Objects.class.getName()
    );

    @ExceptionHandler(IllegalArgumentException.class)
    public void handle(Exception exception) {
        String throwerClassName = exception.getStackTrace()[0].getClassName();
        String callerClassNameOfThrower = exception.getStackTrace()[1].getClassName();

        if (
                exception.getClass().getPackage().getName().startsWith(IN_HOUSE_PACKAGE_PREFIX)
                        || throwerClassName.startsWith(IN_HOUSE_PACKAGE_PREFIX)
                        || (EXCEPTION_UTIL_CLASS_NAMES.contains(throwerClassName) && callerClassNameOfThrower.startsWith(IN_HOUSE_PACKAGE_PREFIX))
        ) {
            LOGGER.log(Level.SEVERE, "패키지 에러입니다. 원인: {0}", exception.getMessage());
            return;
        }

        LOGGER.log(Level.SEVERE, "에러가 발생했습니다. 원인: {0}", exception.getMessage());
    }
}
