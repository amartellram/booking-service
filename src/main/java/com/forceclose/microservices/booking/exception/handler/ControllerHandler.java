package com.forceclose.microservices.booking.exception.handler;

import com.forceclose.microservices.booking.exception.BaseException;
import com.forceclose.microservices.booking.exception.InternalErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ControllerHandler {

    @ExceptionHandler(BaseException.class)
    public HttpEntity<BaseException> handleBaseException(BaseException baseException) {
        log.error("An exception ocurred:", baseException);
        return new ResponseEntity<>(baseException, baseException.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public HttpEntity<BaseException> handleBaseException(Exception exception) {
        log.error("An exception ocurred - root cause:", exception);
        BaseException internalErrorException = new InternalErrorException(exception.getMessage());
        return new ResponseEntity<>(internalErrorException, internalErrorException.getHttpStatus());
    }
}
