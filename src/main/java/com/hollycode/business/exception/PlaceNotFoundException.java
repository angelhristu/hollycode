package com.hollycode.business.exception;

import lombok.Data;


@Data
public class PlaceNotFoundException extends RuntimeException {

    private final String message;
}
