package com.custom.eaii.training.exceptions;

public class BadRequestException extends CmsException {
    private static final long serialVersionUID = 1L;

    public BadRequestException() {
    }

    public BadRequestException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
