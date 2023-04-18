package com.university.studmanager.exceptions;

import org.springframework.http.HttpStatus;

public class AnAlreadyExistsException extends ServerException {
    public AnAlreadyExistsException(String message, ErrorCodes code) {
        super(HttpStatus.CONFLICT, message, code);
    }
}
