package com.university.studmanager.exceptions;

import org.springframework.http.HttpStatus;

public class DepartmentAlreadyExistsException extends ServerException {
    public DepartmentAlreadyExistsException(String message, ErrorCodes code) {
        super(HttpStatus.CONFLICT, message, code);
    }
}
