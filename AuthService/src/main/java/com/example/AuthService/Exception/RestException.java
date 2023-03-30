package com.example.AuthService.Exception;

import com.example.AuthService.Response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestException {
    @ExceptionHandler(AuthExcept.class)
    public ResponseEntity<Response> handleException(AuthExcept e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}
