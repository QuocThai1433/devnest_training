package com.devnest.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // User errors - 1000 series
    USER_NOT_FOUND("user.not.found", 1001),
    USER_ALREADY_EXISTS("user.already.exists", 1002),
    USER_EMAIL_EXISTS("user.email.exists", 1003),
    USER_USERNAME_EXISTS("user.username.exists", 1004),
    USER_INVALID_CREDENTIALS("user.invalid.credentials", 1005),
    USER_UNAUTHORIZED("user.unauthorized", 1006),
    USER_FORBIDDEN("user.forbidden", 1007),
    USER_INVALID_TOKEN("user.invalid.token", 1008),
    USER_PASSWORD_MISMATCH("user.password.mismatch", 1009),
    USER_PASSWORD_WEAK("user.password.weak", 1010),
    USER_EMAIL_INVALID("user.email.invalid", 1011),
    USER_ACCOUNT_LOCKED("user.account.locked", 1012),
    USER_ACCOUNT_DISABLED("user.account.disabled", 1013),
    USER_ACCOUNT_EXPIRED("user.account.expired", 1014),
    USER_SESSION_EXPIRED("user.session.expired", 1015),
    USER_VALIDATION_FAILED("user.validation.failed", 1016),
    
    // Authentication & Authorization errors - 2000 series
    AUTH_TOKEN_EXPIRED("auth.token.expired", 2001),
    AUTH_TOKEN_INVALID("auth.token.invalid", 2002),
    AUTH_TOKEN_MISSING("auth.token.missing", 2003),
    AUTH_INSUFFICIENT_PRIVILEGES("auth.insufficient.privileges", 2004),
    
    // System errors - 5000 series
    SYSTEM_ERROR("system.error", 5001),
    DATABASE_ERROR("database.error", 5002),
    EXTERNAL_SERVICE_ERROR("external.service.error", 5003),
    REQUEST_TIMEOUT("request.timeout", 5004),
    
    // Validation errors - 4000 series
    VALIDATION_ERROR("validation.error", 4001),
    INVALID_REQUEST_FORMAT("invalid.request.format", 4002),
    MISSING_REQUIRED_FIELD("missing.required.field", 4003),
    INVALID_DATA_FORMAT("invalid.data.format", 4004);
    
    private final String messageKey;
    private final int code;
}