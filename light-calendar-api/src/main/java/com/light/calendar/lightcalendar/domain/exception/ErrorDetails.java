package com.light.calendar.lightcalendar.domain.exception;

import java.util.Date;

public class ErrorDetails {

    private Date errorDate;
    private String errorCode;
    private String errorMessage;

    public ErrorDetails(Date errorDate, String errorCode, String errorMessage) {
        this.errorDate = errorDate;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public Date getErrorDate() {
        return errorDate;
    }

    public void setErrorDate(Date errorDate) {
        this.errorDate = errorDate;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
