package com.forceclose.microservices.booking.exception;

import org.springframework.http.HttpStatus;

public class InternalErrorException extends BaseException{
    public InternalErrorException(String message) {
        super("99", message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}