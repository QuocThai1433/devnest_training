package com.devnest.auth.service;

import com.devnest.auth.dto.request.RegisterRequest;
import com.devnest.auth.entity.Role;
import com.devnest.auth.entity.User;

import com.devnest.auth.repository.RoleRepository;
import com.devnest.auth.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository repository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.repository = roleRepository;
    }

    @Transactional
    public User register(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Username Already exist");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setName(request.getName());
        user.setRole(repository.findById(1L).orElseThrow(() -> new RuntimeException("Role not found"))); // Mặc định là admin

        return userRepository.save(user);
    }
}
