package com.custom.eaii.training.api;

public class RequestBean {
    private String correlationId;
    private String csrfToken;
    private String userId;
    private String clientServiceAccessToken;

    public RequestBean() {
    }

    public void initialize(String correlationId, String userId, String csrfToken) {
        this.correlationId = correlationId;
        this.userId = userId;
        this.csrfToken = csrfToken;
    }

    public void setClientServiceAccessToken(String clientServiceAccessToken) {
        this.clientServiceAccessToken = clientServiceAccessToken;
    }

    public String getClientServiceAccessToken() {
        return this.clientServiceAccessToken;
    }

    public String getCorrelationId() {
        return this.correlationId;
    }

    public String getCsrfToken() {
        return this.csrfToken;
    }

    public String getUserId() {
        return this.userId;
    }
}
