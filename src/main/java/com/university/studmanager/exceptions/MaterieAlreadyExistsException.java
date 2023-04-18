package com.university.studmanager.exceptions;

import org.springframework.http.HttpStatus;

public class MaterieAlreadyExistsException extends ServerException {
    public MaterieAlreadyExistsException(String message, ErrorCodes code) {
        super(HttpStatus.CONFLICT, message, code);
    }
}
