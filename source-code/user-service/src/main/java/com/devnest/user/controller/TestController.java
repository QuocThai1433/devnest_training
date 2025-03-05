package com.devnest.user.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devnest.common.config.Translator;
import com.devnest.user.dto.request.TestRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("test")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class TestController {
    Translator translator;

    @PostMapping
    public String get(@RequestBody @Valid TestRequest request) {
        return translator.toLocale("user.add.success");
    }
}