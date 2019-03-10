package com.light.calendar.domain.exception;

public abstract class BusinessException extends RuntimeException {

    private String locale;
    private String correlationId;

    public BusinessException(String message, String locale, String correlationId) {
        super(message);
        this.locale = locale;
        this.correlationId = correlationId;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }
}
