package com.example.zooanimalcountapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {

        @ExceptionHandler(value = NotFoundException.class)
        public ResponseEntity<ExceptionResponse> handleException(NotFoundException e) {
               return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ExceptionResponse(e.getMessage()));
        }
}
