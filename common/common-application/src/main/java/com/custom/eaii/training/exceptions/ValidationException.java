package com.custom.eaii.training.exceptions;

import com.custom.eaii.training.api.error.ValidationError;

import java.util.List;

public class ValidationException extends CmsException{
    private static final long serialVersionUID = 1L;
    private List<ValidationError> validationErrors;

    public ValidationException() {
    }

    public ValidationException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public ValidationException(List<ValidationError> validationErrors) {
        this.setValidationErrors(validationErrors);
    }

    public ValidationException(List<ValidationError> validationErrors, String message) {
        super(message);
        this.setValidationErrors(validationErrors);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationException(String msg) {
        super(msg);
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }

    public List<ValidationError> getValidationErrors() {
        return this.validationErrors;
    }

    public void setValidationErrors(List<ValidationError> validationErrors) {
        this.validationErrors = validationErrors;
    }
}
