package com.stefano.dev.config.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ErrorMensaje.class)
    public ResponseEntity<Object> handleBusinessException(ErrorMensaje ex){
        return ResponseEntity.status(ex.getStatus()).body(new ErrorDto(ex.getMessage(), LocalDateTime.now(),ex.getStatus().value()));
    }
}
