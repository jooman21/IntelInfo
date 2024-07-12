package com.custom.eaii.training.constant;

public enum CommonConstants {
    CORRELATION_ID_HEADER("x-correlation-id"),
    REQ_CSRF_TOKEN_HEADER("x-xsrf-token"),
    REQUEST_ID_HEADER("x-request-id");

    private String value;

    private CommonConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}