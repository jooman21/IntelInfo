package com.custom.eaii.training.api.error;

public class ValidationError {
    private String code;
    private String message;
    private String field;

    public ValidationError() {
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getField() {
        return this.field;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setField(String field) {
        this.field = field;
    }
}
