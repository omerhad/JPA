package com.CPmovement.mapping_and_viewing_info.exception;

import lombok.Getter;

@Getter
public class ApiException {
    // Getters and setters
    private final String errorCode;
    private final String message;
    private final String timestamp;

    public ApiException(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
        this.timestamp = java.time.LocalDateTime.now().toString();
    }


}
