package com.example.CourseService.Exceptions;

import com.example.CourseService.Response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestException {
    private static Logger log = LoggerFactory.getLogger(RestException.class);
    @ExceptionHandler(CourseExcept.class)
    public ResponseEntity<Response> handleException(CourseExcept e) {
        Response response = new Response(e.getMessage());
        log.info(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}