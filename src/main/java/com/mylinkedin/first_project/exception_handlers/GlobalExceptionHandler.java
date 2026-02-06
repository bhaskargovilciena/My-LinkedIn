package com.mylinkedin.first_project.exception_handlers;

import com.mylinkedin.first_project.exceptions.CompanyNotFoundException;
import com.mylinkedin.first_project.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleUserNotFoundException(UserNotFoundException exception) {
        Map<String, Object> userResponse = new HashMap<>();
        userResponse.put("status", HttpStatus.BAD_REQUEST.value());
        userResponse.put("message", exception.getMessage());
        userResponse.put("timestamp", LocalDateTime.now());
        userResponse.put("error", "bad request");
        return new ResponseEntity<>(userResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleCompanyNotFoundException(CompanyNotFoundException exception) {
        Map<String, Object> companyResponse = new HashMap<>();
        companyResponse.put("status", HttpStatus.BAD_REQUEST.value());
        companyResponse.put("message", exception.getMessage());
        companyResponse.put("timestamp", LocalDateTime.now());
        companyResponse.put("error", "bad request");
        return new ResponseEntity<>(companyResponse, HttpStatus.BAD_REQUEST);
    }
}
