package com.forceclose.microservices.booking.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@JsonIgnoreProperties({ "cause", "stackTrace", "suppressed", "localizedMessage", "httpStatus" })
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 1412579419703807855L;
    private String code;
    private String message;
    private HttpStatus httpStatus;
}