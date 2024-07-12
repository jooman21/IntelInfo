package com.custom.eaii.training.exception;

import com.custom.eaii.training.domain.exception.DomainException;

public class RegisterReasonDomainException extends DomainException {
    public RegisterReasonDomainException(String message) {
        super(message);
    }

    public RegisterReasonDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
