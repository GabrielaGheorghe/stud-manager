package com.university.studmanager.exceptions;

import org.springframework.http.HttpStatus;

public class StudentAlreadyExistsException extends ServerException{

    public StudentAlreadyExistsException(String message, ErrorCodes code) {
        super(HttpStatus.CONFLICT, message, code);
    }

}
