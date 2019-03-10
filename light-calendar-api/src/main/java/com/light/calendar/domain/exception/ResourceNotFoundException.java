package com.light.calendar.domain.exception;

public class ResourceNotFoundException extends BusinessException {

    public ResourceNotFoundException(String message, String locale) {
        super(message, locale);
    }
}
