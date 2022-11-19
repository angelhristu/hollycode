package com.hollycode.business.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ErrorResponse {

    private final String message;
    private final String serviceName;
    private final String uri;
    private final HttpStatus status;

    public static ErrorResponse of(String message, String serviceName, String uri, HttpStatus httpStatus) {
        return new ErrorResponse(message, serviceName, uri, httpStatus);
    }

}
