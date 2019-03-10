package com.light.calendar.domain.exception;

public class RequestNotValidException extends BusinessException {

    public RequestNotValidException(String message, String locale, String correlationId) {
        super(message, locale, correlationId);
    }
}
