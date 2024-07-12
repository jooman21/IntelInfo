package com.custom.eaii.training.util.notification.email;

import com.custom.eaii.training.constant.CommonConstants;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.web.server.ServerWebExchange;

import java.util.UUID;

public class CorrelationIdGenerator {
    public CorrelationIdGenerator() {
    }

    public static String getCorrelationId(ServerWebExchange serverWebExchange) {
        HttpHeaders headers = serverWebExchange.getRequest().getHeaders();
        return headers.get(CommonConstants.CORRELATION_ID_HEADER) != null ? (String)headers.get(CommonConstants.CORRELATION_ID_HEADER).get(0) : UUID.randomUUID().toString();
    }

    public static String getCorrelationId(HttpServletRequest request) {
        return request.getHeader(CommonConstants.CORRELATION_ID_HEADER.getValue()) != null ? request.getHeader(CommonConstants.CORRELATION_ID_HEADER.getValue()) : UUID.randomUUID().toString();
    }
}
