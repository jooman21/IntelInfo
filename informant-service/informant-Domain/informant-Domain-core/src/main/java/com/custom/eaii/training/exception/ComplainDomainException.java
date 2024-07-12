package com.custom.eaii.training.exception;

import com.custom.eaii.training.domain.exception.DomainException;

public class ComplainDomainException extends DomainException {
    public ComplainDomainException(String message) {
        super(message);
    }

    public ComplainDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
