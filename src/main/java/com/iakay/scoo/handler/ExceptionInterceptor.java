package com.iakay.scoo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ValidationException;

/**
 * Created by iakay on 2020-01-19.
 */
@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ValidationException.class)
    public final ResponseEntity<Object> handler(ValidationException ex) {
        String exceptionResponse = String.format("Invalid input parameters: %s \n", ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
