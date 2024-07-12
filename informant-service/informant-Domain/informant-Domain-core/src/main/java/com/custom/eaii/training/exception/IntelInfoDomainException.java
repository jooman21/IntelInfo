package com.custom.eaii.training.exception;

import com.custom.eaii.training.domain.exception.DomainException;

public class IntelInfoDomainException extends DomainException {
    public IntelInfoDomainException(String message){
        super(message);
    }
    public IntelInfoDomainException(String message, Throwable cause){
        super(message, cause);
    }
}
