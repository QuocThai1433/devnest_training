package com.devnest.user.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class TestRequest {
    
    @Size(min = 3,message = "{user.validation.failed}")
    private String username;
}
