package com.example.AuthService.Exception;

import com.example.AuthService.Response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestException {
    private static Logger log = LoggerFactory.getLogger(RestException.class);
    @ExceptionHandler(AuthExcept.class)
    public ResponseEntity<Response> handleException(AuthExcept e) {
        Response response = new Response(e.getMessage());

        log.info(e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}
