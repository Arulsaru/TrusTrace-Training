package com.socialmedia.instagram.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<APIResponse> handleException(Exception e) {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        apiResponse.setError(e.getMessage());
        return ResponseEntity.status(500).body(apiResponse);
    }
}
