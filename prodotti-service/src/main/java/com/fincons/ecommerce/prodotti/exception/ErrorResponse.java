package com.fincons.ecommerce.prodotti.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ErrorResponse {

    private LocalDateTime date;

    private int code;

    private String message;

    private String path;

    ErrorResponse() {
        date = LocalDateTime.now();
    }
}