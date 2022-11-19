package com.hollycode.business.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @Value("${spring.application.name}")
    private String serviceName;

    @ExceptionHandler(PlaceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePlaceNotFoundException(PlaceNotFoundException exception, HttpServletRequest request) {
        return handleException(exception, request, NOT_FOUND);
    }

    private ResponseEntity<ErrorResponse> handleException(Exception exception, HttpServletRequest request, HttpStatus httpStatus) {
        log.error(exception.getMessage(), exception);

        return new ResponseEntity<>(
                ErrorResponse.of(exception.getMessage(), serviceName, request.getRequestURI(), httpStatus),
                httpStatus);
    }
}