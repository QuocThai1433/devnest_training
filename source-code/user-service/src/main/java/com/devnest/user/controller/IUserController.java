package com.devnest.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface IUserController {
    @RequestMapping("delete/{id}")
    ResponseEntity<Boolean> delete (@PathVariable Long Id);
}
