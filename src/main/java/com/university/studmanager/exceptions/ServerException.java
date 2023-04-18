package com.university.studmanager.exceptions;

import org.springframework.http.HttpStatus;

public class ServerException extends Exception {

    private final HttpStatus status;
    private final ErrorCodes code;

    public ServerException(HttpStatus status, String message, ErrorCodes code) {
        super(message);
        this.status = status;
        this.code = code;
    }
}
