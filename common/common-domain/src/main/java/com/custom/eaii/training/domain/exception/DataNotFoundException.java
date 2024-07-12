package com.custom.eaii.training.domain.exception;

import java.io.Serial;

public class DataNotFoundException extends DomainException {
    @Serial
    private static final long serialVersionUID = 1L;
    private String resource;

    public DataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataNotFoundException(String msg) {
        super(msg);
    }

    public String getResource() {
        return this.resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
