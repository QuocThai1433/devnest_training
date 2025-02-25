package com.devnest.auth.controller;

import com.devnest.auth.config.JWTService;
import com.devnest.auth.dto.request.IntrospectRequest;
import com.devnest.auth.dto.request.LoginRequest;
import com.devnest.auth.dto.request.RefreshTokenRequest;
import com.devnest.auth.dto.request.RegisterRequest;
import com.devnest.auth.dto.response.IntrospectResponse;
import com.devnest.auth.dto.response.LoginResponse;
import com.devnest.auth.dto.response.RegisterResponse;
import com.devnest.auth.service.AuthService;
import com.devnest.auth.service.CustomUserDetailService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.text.ParseException;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class AuthController {
    AuthenticationManager authenticationManager;
    JWTService jwtService;
    CustomUserDetailService customUserDetailService;
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, @RequestParam String role) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
            UserDetails userDetails = customUserDetailService.loadUserByUsernameAndRole(loginRequest.getUsername(), role);

            String accessToken = jwtService.generateAccessToken(userDetails, role);
            String refreshToken = jwtService.generateRefreshToken(userDetails, role);

            return ResponseEntity.ok(new LoginResponse(accessToken, refreshToken));
        } catch (BadCredentialsException | InternalAuthenticationServiceException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("error 2:" + e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        try {
            RegisterResponse response = authService.registerUser(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RestClientException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body("Không thể kết nối tới course-service: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Lỗi hệ thống: " + e.getMessage());
        }
    }

    @PostMapping("/introspect")
    public IntrospectResponse authenticate(@RequestBody IntrospectRequest request) throws ParseException {
        var result = jwtService.introspect(request);
        return IntrospectResponse.builder()
                .valid(result.isValid())
                .build();
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenRequest request) {
        String refreshToken = request.getRefreshToken();

        if (refreshToken == null || refreshToken.isEmpty()) {
            return ResponseEntity.badRequest().body("Refresh token không được để trống!");
        }

        try {
            if (jwtService.isTokenExpired(refreshToken)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Refresh token đã hết hạn!");
            }

            String username = jwtService.extractUsername(refreshToken);
            String role = jwtService.extractRole(refreshToken);

            UserDetails userDetails = customUserDetailService.loadUserByUsernameAndRole(username, role);

            if (!jwtService.validateToken(refreshToken, userDetails)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Refresh token không hợp lệ!");
            }

            String newAccessToken = jwtService.generateAccessToken(userDetails, role);
            return ResponseEntity.ok(new LoginResponse(newAccessToken, refreshToken));

        } catch (ExpiredJwtException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Refresh token đã hết hạn!");
        } catch (JwtException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token không hợp lệ!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi server khi xử lý refresh token!");
        }
    }

}
