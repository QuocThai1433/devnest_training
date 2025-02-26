package com.devnest.auth.service;

import com.devnest.auth.config.JWTService;
import com.devnest.auth.dto.request.RegisterRequest;
import com.devnest.auth.dto.response.RegisterResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class AuthService {
    RestTemplate restTemplate;
    PasswordEncoder passwordEncoder;
    JWTService jwtService;

    @NonFinal
    String URL = "http://course/api/v1/course/internal/register";

    /**
     * Đăng ký người dùng mới
     */
    public RegisterResponse registerUser(RegisterRequest request) {

        RegisterRequest courseRequest = new RegisterRequest();
        courseRequest.setUsername(request.getUsername());
        courseRequest.setPassword(passwordEncoder.encode(request.getPassword()));
        courseRequest.setRole(request.getRole());
        courseRequest.setFirstName(request.getFirstName());
        courseRequest.setLastName(request.getLastName());
        courseRequest.setEmail(request.getEmail());
        courseRequest.setPhone(request.getPhone());
        courseRequest.setDescription(request.getDescription());

        if ("student".equalsIgnoreCase(request.getRole())) {
            courseRequest.setDateBirth(request.getDateBirth());
            courseRequest.setState(request.getState());
            courseRequest.setCity(request.getCity());
            courseRequest.setZipCode(request.getZipCode());
            courseRequest.setStreet(request.getStreet());
        } else if ("teacher".equalsIgnoreCase(request.getRole())) {
            courseRequest.setImageUrl(request.getImageUrl());
        } else if ("staff".equalsIgnoreCase(request.getRole())) {
            courseRequest.setPosition(request.getPosition());
        }

//        String url = "http://course/api/v1/course/internal/register";
        HttpEntity<RegisterRequest> requestEntity = new HttpEntity<>(courseRequest);
        ResponseEntity<String> courseResponse = restTemplate.exchange(
                URL,
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        if (!courseResponse.getStatusCode().is2xxSuccessful()) {
            throw new IllegalArgumentException("Không thể đăng ký tài khoản: " + courseResponse.getBody());
        }

        // Tạo JWT token nếu cần đăng nhập ngay
//        String token = jwtService.generateAccessToken(request.getUsername(), request.getRole());

        // Trả về kết quả
        return RegisterResponse.builder()
                .username(request.getUsername())
                .role(request.getRole())
                .message("Đăng ký tài khoản thành công")
//                .token(token)
                .build();
    }


}
