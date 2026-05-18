package com.stefano.dev.config.exception;

import java.time.LocalDateTime;


public record ErrorDto (
        String mensaje,
        LocalDateTime fechaHora,
        int status
){
}
