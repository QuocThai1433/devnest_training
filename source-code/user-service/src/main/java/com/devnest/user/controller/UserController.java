package com.devnest.user.controller;

import com.devnest.user.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {
    public final TeacherService service;

    public UserController(TeacherService service) {
        this.service = service;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long Id) {
        return ResponseEntity.ok(service.delete(Id));
    }
}
