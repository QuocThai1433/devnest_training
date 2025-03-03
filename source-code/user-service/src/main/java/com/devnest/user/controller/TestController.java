package com.devnest.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devnest.user.config.Translator;
import com.devnest.user.dto.request.TestRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("test")
public class TestController {
    @PostMapping
    public String get(@RequestBody @Valid TestRequest request) {               
        return Translator.toLocale("user.add.success");
    }
}
