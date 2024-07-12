package com.custom.eaii.training.handler;

import com.custom.eaii.training.api.Response;
import com.custom.eaii.training.api.error.GlobalError;
import com.custom.eaii.training.constant.ErrorCodes;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.stream.Collectors;

@RestControllerAdvice

public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    public GlobalExceptionHandler() {
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response handleException(Exception exception) {
        log.error(exception.getMessage(), exception);
        return Response.builder().error(GlobalError.builder().code(ErrorCodes.GENERIC_ERROR.getCode()).message(ErrorCodes.GENERIC_ERROR.getMessage()).build()).build();
    }

    @ExceptionHandler({ValidationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleException(ValidationException validationException) {
        Response response;
        String violations;
        if (validationException instanceof ConstraintViolationException) {
            violations = this.extractViolationsFromException((ConstraintViolationException)validationException);
            log.error(violations, validationException);
            response = Response.builder().error(GlobalError.builder().code(ErrorCodes.BAD_REQUEST.getCode()).message(violations).build()).build();
        } else {
            violations = validationException.getMessage();
            log.error(violations, validationException);
            response = Response.builder().error(GlobalError.builder().code(ErrorCodes.BAD_REQUEST.getCode()).message(violations).build()).build();
        }

        return response;
    }

    private String extractViolationsFromException(ConstraintViolationException validationException) {
        return (String)validationException.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining("--"));
    }
}
