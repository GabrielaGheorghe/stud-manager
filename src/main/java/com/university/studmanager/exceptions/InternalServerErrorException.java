package com.university.studmanager.exceptions;

import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends ServerException {
    public InternalServerErrorException(String message, ErrorCodes code) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message, code);
    }
}
