package com.university.studmanager.exceptions;

import org.springframework.http.HttpStatus;

public class SerieAlreadyExistsException extends ServerException {

    public SerieAlreadyExistsException(String message, ErrorCodes code) {
        super(HttpStatus.CONFLICT, message, code);
    }
}
