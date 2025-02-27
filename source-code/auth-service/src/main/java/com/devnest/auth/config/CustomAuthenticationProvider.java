package com.devnest.auth.config;

import com.devnest.auth.service.CustomUserDetailService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final CustomUserDetailService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomAuthenticationProvider(CustomUserDetailService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString(); // Lấy mật khẩu từ request
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (!(requestAttributes instanceof ServletRequestAttributes)) {
            throw new BadCredentialsException("Không thể lấy request hiện tại");
        }
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

        String role = request.getParameter("role");
        if (role == null || role.isEmpty()) {
            throw new BadCredentialsException("Role không được để trống");
        }

        UserDetails user;

        try {
            user = userDetailsService.loadUserByUsernameAndRole(username, role);
        } catch (UsernameNotFoundException e) {
            throw new BadCredentialsException("Username hoặc mật khẩu không đúng!");
        }

        // Kiểm tra mật khẩu
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Mật khẩu không chính xác!");
        }

        return new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}

