package com.university.studmanager.exceptions;

import org.springframework.http.HttpStatus;

public class FacultyAlreadyExistsException extends  ServerException{
    public FacultyAlreadyExistsException(String message, ErrorCodes code) {
        super(HttpStatus.CONFLICT, message, code);
    }
}
