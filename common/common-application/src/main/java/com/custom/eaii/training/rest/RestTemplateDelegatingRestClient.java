package com.custom.eaii.training.rest;

import com.custom.eaii.training.api.Response;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Map;

@Service
public class RestTemplateDelegatingRestClient implements RestClient{    private static final String URI_SERVICE_ID_PLACEHOLDER = "URI-SERVICE-ID-PLACEHOLDER";
    private final RestTemplate restTemplate;

    public RestTemplateDelegatingRestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <T> ResponseEntity<T> executeGet(String serviceName, String path, HttpHeaders httpHeaders, Class<T> responseType) {
        return this.restTemplate.exchange(this.createUriString(serviceName, path), HttpMethod.GET, new HttpEntity((Object)null, httpHeaders), ParameterizedTypeReference.forType(responseType), new Object[0]);
    }

    public Response executePost(String serviceName, String path, Object request, Class<Response> responseType, Object... uriVariable) {
        return (Response)this.restTemplate.postForObject(this.createUriString(serviceName, path), request, responseType, uriVariable);
    }

    public ResponseEntity<Response> executePut(String serviceName, String path, Object request, Class<Response> responseType, Object... uriVariable) {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<Object> entity = new HttpEntity(request, httpHeaders);
        return this.restTemplate.exchange(this.createUriString(serviceName, path), HttpMethod.PUT, entity, responseType, uriVariable);
    }

    public final String getClientServiceAccessToken(String accessTokenEndpoint, String serviceClientId, String serviceClientSecret) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        MultiValueMap<String, String> map = new LinkedMultiValueMap();
        map.add("grant_type", "client_credentials");
        map.add("client_id", serviceClientId);
        map.add("client_secret", serviceClientSecret);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity(map, headers);
        ResponseEntity<Map> response = this.restTemplate.exchange(accessTokenEndpoint, HttpMethod.POST, entity, Map.class, new Object[0]);
        if (response.getStatusCode() == HttpStatus.OK) {
            return (String)((Map)response.getBody()).get("access_token");
        } else {
            throw new RuntimeException("Failed to get access token");
        }
    }

    private URI createUri(String serviceName, String path, MultiValueMap<String, String> queryStringMap) {
        URI placeHolderUri = this.schemeHostPathBuilder(path).queryParams(queryStringMap).build().encode().toUri();
        return URI.create(this.replaceServiceId(serviceName, placeHolderUri.toString()));
    }

    private String createUriString(String serviceName, String path) {
        return this.replaceServiceId(serviceName, this.schemeHostPathBuilder(path).build().toUriString());
    }

    private String replaceServiceId(String serviceName, String uriString) {
        return uriString.replace("URI-SERVICE-ID-PLACEHOLDER", serviceName);
    }

    private UriComponentsBuilder schemeHostPathBuilder(String path) {
        return UriComponentsBuilder.newInstance().scheme("http").host("URI-SERVICE-ID-PLACEHOLDER").path(path);
    }
}
