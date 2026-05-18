package com.stefano.dev.config.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class ErrorMensaje extends RuntimeException{
    private final HttpStatus status;
    public ErrorMensaje(String mensaje, HttpStatus httpStatus){
        super(mensaje);
        this.status = httpStatus;
    }
}
