package com.devnest.apigateway.service;

import com.devnest.apigateway.dto.IntrospectDTO;
import com.devnest.apigateway.repository.IdentityClient;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class IdentityService {
    IdentityClient identityClient;

    public Mono<IntrospectDTO> introspect(String token){
        return identityClient.introspect(IntrospectDTO.builder()
                .token(token)
                .build());
    }

}
