package com.devnest.course.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devnest.course.service.AuthenticationService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auth")
@Slf4j(topic = "AUTHENTICATION-CONTROLLER")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
	
	AuthenticationService authenticationService;
	
//	@PostMapping("/access-token")
//    public TokenResponse accessToken(@RequestBody SignInRequest request) {
//        log.info("Access token request");
//
//        return authenticationService.getAccessToken(request);
//    }
	
//	@PostMapping("/refresh-token")
//    public TokenResponse refreshToken(@RequestBody String refreshToken) {
//        log.info("Refresh token request");
//
//        return authenticationService.getRefreshToken(refreshToken);
//    }
}
