package com.university.studmanager.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends ServerException {
    public UserNotFoundException(String message, ErrorCodes code) {
        super(HttpStatus.CONFLICT, message, code);
    }

}
