package com.devnest.apigateway.repository;

import com.devnest.apigateway.dto.IntrospectDTO;
//import com.devnest.apigateway.dto.LoginDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

public interface IdentityClient {
//    @PostExchange(url = "auth/login",contentType = MediaType.APPLICATION_JSON_VALUE)
//    Mono<IntrospectDTO> login(@RequestBody LoginDTO request);
    @PostExchange(url = "auth/introspect",contentType = MediaType.APPLICATION_JSON_VALUE)
    Mono<IntrospectDTO> introspect(@RequestBody IntrospectDTO request);
}
