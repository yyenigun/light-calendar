package com.light.calendar.domain.exception;

public class ResourceNotFoundException extends BusinessException {

    public ResourceNotFoundException(String message, String locale, String correlationId) {
        super(message, locale, correlationId);
    }
}
