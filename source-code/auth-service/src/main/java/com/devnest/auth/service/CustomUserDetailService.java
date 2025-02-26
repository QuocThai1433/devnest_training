package com.devnest.auth.service;

import com.devnest.auth.dto.response.AuthCourseResponseDTO;
import com.devnest.auth.repository.CustomUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Service
public class CustomUserDetailService implements UserDetailsService {
    private final RestTemplate restTemplate;

    public CustomUserDetailService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        throw new UnsupportedOperationException("Dùng phương thức loadUserByUsernameAndRole()");
    }

    public UserDetails loadUserByUsernameAndRole(String username, String role) throws UsernameNotFoundException {
        String url = "http://api-gateway/api/v1/course/internal/user?username=" + username + "&role=" + role;

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("X-Internal-Call", "true"); // ✅ Đánh dấu request nội bộ từ auth-service

            HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

            ResponseEntity<AuthCourseResponseDTO> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    requestEntity,
                    AuthCourseResponseDTO.class
            );

            if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
                throw new UsernameNotFoundException("User không tồn tại");
            }

            return new CustomUserDetails(response.getBody());
        } catch (RestClientException e) {
            throw new UsernameNotFoundException("Lỗi khi gọi course-service: " + e.getMessage());
        }
    }

}
