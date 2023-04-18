package com.university.studmanager.exceptions;

import org.springframework.http.HttpStatus;

public class GrupaAlreadyExistsException extends ServerException {

    public GrupaAlreadyExistsException(String message, ErrorCodes code) {
        super(HttpStatus.CONFLICT, message, code);
    }
}
