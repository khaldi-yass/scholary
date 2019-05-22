package com.yassir.scholary.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Illegal operation")
public class IllegalOperationException extends RuntimeException {

    private static final String NOT_FOUND_ERROR = "Can't find Employee with ";
    private Class clazz;

    public IllegalOperationException(Class clazz, String message) {
        super(NOT_FOUND_ERROR + message);
        this.clazz = clazz;
    }

    public Class getClazz() {
        return clazz;
    }
}
