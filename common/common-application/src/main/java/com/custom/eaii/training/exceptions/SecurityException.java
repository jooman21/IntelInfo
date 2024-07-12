package com.custom.eaii.training.exceptions;

public class SecurityException extends CmsException{

    private static final long serialVersionUID = 1L;

    public SecurityException() {
    }

    public SecurityException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public SecurityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public SecurityException(String message, Throwable cause) {
        super(message, cause);
    }

    public SecurityException(String message) {
        super(message);
    }

    public SecurityException(Throwable cause) {
        super(cause);
    }
}
