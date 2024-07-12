package com.custom.eaii.training.filter;

import com.custom.eaii.training.api.RequestBean;
import com.custom.eaii.training.constant.CommonConstants;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.security.Principal;
import java.util.Optional;
import java.util.UUID;

@Component
public class RequestFilter extends OncePerRequestFilter {
    private static final Logger log = LoggerFactory.getLogger(RequestFilter.class);
    private RequestBean requestBean;
    @Value("${cms.service-name}")
    private String serviceName;

    public RequestFilter(RequestBean requestBean) {
        this.requestBean = requestBean;
    }

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String corrId = request.getHeader(CommonConstants.CORRELATION_ID_HEADER.getValue());
        String csrfToken = request.getHeader(CommonConstants.REQ_CSRF_TOKEN_HEADER.getValue());
        String userId = this.pullAuthenticatedUser();
        if (!StringUtils.hasText(corrId)) {
            corrId = UUID.randomUUID().toString();
        }

        this.addToMDC("corrId", corrId);
        this.addToMDC("userId", userId);
        this.addToMDC("serviceName", this.serviceName);
        this.requestBean.initialize(corrId, userId, csrfToken);
        filterChain.doFilter(request, response);
    }

    private void addToMDC(String key, String value) {
        if (StringUtils.hasText(key) && StringUtils.hasText(value)) {
            MDC.put(key, value);
        }

    }

    private String pullAuthenticatedUser() {
        try {
            Optional<String> userId = Optional.ofNullable(SecurityContextHolder.getContext()).map(SecurityContext::getAuthentication).filter(Authentication::isAuthenticated).map(Principal::getName);
            if (userId.isPresent()) {
                return (String)userId.get();
            }
        } catch (Exception var2) {
            log.error(var2.getMessage(), var2);
        }

        return "";
    }
}
