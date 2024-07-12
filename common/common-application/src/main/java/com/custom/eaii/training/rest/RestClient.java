package com.custom.eaii.training.rest;

import com.custom.eaii.training.api.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public interface RestClient {
    <T> ResponseEntity<T> executeGet(String var1, String var2, HttpHeaders var3, Class<T> var4);

    Response executePost(String var1, String var2, Object var3, Class<Response> var4, Object... var5);

    ResponseEntity<Response> executePut(String var1, String var2, Object var3, Class<Response> var4, Object... var5);

    String getClientServiceAccessToken(String var1, String var2, String var3);
}
