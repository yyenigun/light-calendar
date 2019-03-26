package com.light.calendar.application.model;

public abstract class BaseResource {

    private static final String DEFAULT_LOCALE = "EN";
    private String locale;

    public String getLocale() {
        return locale;
    }

    public static String getDefaultLocale() {
        return DEFAULT_LOCALE;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
