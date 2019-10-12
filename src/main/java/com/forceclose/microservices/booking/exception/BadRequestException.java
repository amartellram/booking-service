package com.forceclose.microservices.booking.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException  extends BaseException{
    public BadRequestException(String message) {
        super("03.01", message, HttpStatus.BAD_REQUEST);
    }
}