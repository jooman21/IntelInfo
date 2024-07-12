package com.custom.eaii.training.exceptions;

public class IntelInfoException  extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String errorCode;
    private String errorMessage;
    private String correlationId;

    public IntelInfoException(){
    }
    public IntelInfoException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    public IntelInfoException(String message) {
        super(message);
    }

    public IntelInfoException(Throwable cause) {
        super(cause);
    }

    public IntelInfoException(String message, Throwable cause) {
        super(message, cause);
    }

    public IntelInfoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
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
