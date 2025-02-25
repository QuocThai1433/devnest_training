package com.devnest.auth.service;

import com.devnest.auth.dto.response.AuthCourseResponseDTO;
import com.devnest.auth.repository.CustomUserDetails;
import lombok.extern.slf4j.Slf4j;
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
        String url = "http://localhost:8081/api/v1/course/internal/user?username=" + username + "&role=" + role;

        try {
            AuthCourseResponseDTO response = restTemplate.getForObject(url, AuthCourseResponseDTO.class);
            if (response == null) throw new UsernameNotFoundException("User không tồn tại");

            return new CustomUserDetails(response);
        } catch (RestClientException e) {
            throw new UsernameNotFoundException("Lỗi khi gọi course-service: " + e.getMessage());
        }
    }
}
