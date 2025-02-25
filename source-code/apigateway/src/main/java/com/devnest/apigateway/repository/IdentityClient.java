package com.devnest.apigateway.repository;

import com.devnest.apigateway.dto.ApiResponse;
import com.devnest.apigateway.dto.request.IntrospectRequest;
import com.devnest.apigateway.dto.response.IntrospectResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

public interface IdentityClient {
    @PostExchange(url = "/auth/introspect", contentType = MediaType.APPLICATION_JSON_VALUE)
    Mono<IntrospectResponse> introspect(@RequestBody IntrospectRequest request);
}