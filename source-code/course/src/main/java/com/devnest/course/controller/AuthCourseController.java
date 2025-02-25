package com.devnest.course.controller;

import com.devnest.course.dto.request.RegisterRequest;
import com.devnest.course.dto.response.AuthCourseResponseDTO;
import com.devnest.course.exception.UsernameNotFoundException;
import com.devnest.course.service.AuthCourseService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course/internal")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthCourseController {
    final AuthCourseService authCourseService;

    public AuthCourseController(AuthCourseService authCourseService) {
        this.authCourseService = authCourseService;
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUser(@RequestParam String username, @RequestParam String role) {
        try {
            AuthCourseResponseDTO user = authCourseService.findUserByUsernameAndRole(username, role);
            return ResponseEntity.ok(user);
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi hệ thống: " + e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerAccount(@RequestBody RegisterRequest request) {
        try {
            // Tạo tài khoản dựa vào role
            String username = authCourseService.createAccount(request);
            return ResponseEntity.status(HttpStatus.CREATED).body("Tài khoản " + username + " đã được tạo thành công");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi hệ thống: " + e.getMessage());
        }
    }
}
