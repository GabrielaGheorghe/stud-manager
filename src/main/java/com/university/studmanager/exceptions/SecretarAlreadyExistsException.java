package com.university.studmanager.exceptions;

import org.springframework.http.HttpStatus;

public class SecretarAlreadyExistsException extends ServerException {
    public SecretarAlreadyExistsException(String message, ErrorCodes code) {
        super(HttpStatus.CONFLICT, message, code);
    }

}
