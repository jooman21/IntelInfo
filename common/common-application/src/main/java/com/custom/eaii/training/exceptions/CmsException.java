package com.custom.eaii.training.exceptions;

public class CmsException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String errorCode;
    private String errorMessage;
    private String correlationId;

    public CmsException() {
    }

    public CmsException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public CmsException(String message) {
        super(message);
    }

    public CmsException(Throwable cause) {
        super(cause);
    }

    public CmsException(String message, Throwable cause) {
        super(message, cause);
    }

    public CmsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getCorrelationId() {
        return this.correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }
}
