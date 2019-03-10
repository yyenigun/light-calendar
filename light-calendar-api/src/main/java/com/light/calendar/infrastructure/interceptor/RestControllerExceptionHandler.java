package com.light.calendar.infrastructure.interceptor;

import com.light.calendar.domain.exception.BusinessException;
import com.light.calendar.domain.exception.ErrorDetail;
import com.light.calendar.domain.exception.RequestNotValidException;
import com.light.calendar.domain.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.Locale;

@ControllerAdvice
public class RestControllerExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(RestControllerExceptionHandler.class);
    private static final String ERROR_MESSAGE_DELIMITER = ";";

    private MessageSource messageSource;

    public RestControllerExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundExceptionHandler(Locale locale, ResourceNotFoundException ex, WebRequest request) {
        logger.warn("An error occurred. Correlation id: {}, Message : {}, Context Path: {}",
                ex.getCorrelationId(), ex.getMessage(), request.getContextPath(), ex);
        return createResponseEntity(locale, ex, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RequestNotValidException.class)
    public ResponseEntity<?> requestNotValidExceptionHandler(Locale locale, BusinessException ex, WebRequest request) {
        logger.warn("An error occurred. Correlation id: {}, Message : {}, Context Path: {}",
                ex.getCorrelationId(), ex.getMessage(), request.getContextPath(), ex);
        return createResponseEntity(locale, ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Locale locale, Exception e) {
        logger.error(e.getMessage(), e);
        ErrorDetail errorDetail = createErrorDetail("system.error", locale);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetail);
    }

    private ResponseEntity<?> createResponseEntity(Locale locale, BusinessException e, HttpStatus status) {
        ErrorDetail errorDetail;
        if (e.getLocale() != null) {
            errorDetail = createErrorDetail(e.getMessage(), Locale.forLanguageTag(e.getLocale()));
        } else {
            errorDetail = createErrorDetail(e.getMessage(), locale);
        }
        return new ResponseEntity<>(errorDetail, status);
    }

    private ErrorDetail createErrorDetail(String errorMessage, Locale locale) {
        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setErrorDate(new Date());
        String message = messageSource.getMessage(errorMessage, null, locale);
        String[] errorCodeMessage = message.split(ERROR_MESSAGE_DELIMITER);
        errorDetail.setErrorCode(errorCodeMessage[0]);
        errorDetail.setErrorMessage(errorCodeMessage[1]);
        return errorDetail;
    }
}
