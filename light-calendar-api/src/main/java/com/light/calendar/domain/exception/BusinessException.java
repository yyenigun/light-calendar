package com.light.calendar.domain.exception;

public abstract class BusinessException extends RuntimeException {

    private String locale;

    public BusinessException(String message, String locale) {
        super(message);
        this.locale = locale;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
