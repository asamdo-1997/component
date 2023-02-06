package com.example.game.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.OptimisticLockException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = { ConnectionErrorException.class })
    protected ResponseEntity<Object> handleConnectionError(
            ConnectionErrorException e, WebRequest request) {
        String bodyOfResponse = e.getMessage();
        return handleExceptionInternal(e, bodyOfResponse,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value
            = { NotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(
            NotFoundException e, WebRequest request) {
        String bodyOfResponse = e.getMessage();
        return handleExceptionInternal(e, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value
            = { OptimisticLockException.class })
    protected ResponseEntity<Object> lockError(
            OptimisticLockException e, WebRequest request) {
        String bodyOfResponse = e.getMessage();
        return handleExceptionInternal(e, bodyOfResponse,
                new HttpHeaders(), HttpStatus.LOCKED, request);
    }
}
