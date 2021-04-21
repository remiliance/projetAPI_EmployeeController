package com.webetapi.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class EmployeeIntrouvableException extends RuntimeException {
    public EmployeeIntrouvableException(String s) {
        super(s);
    }
}
