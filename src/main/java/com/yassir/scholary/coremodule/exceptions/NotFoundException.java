package com.yassir.scholary.coremodule.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Element Not found")
public class NotFoundException extends RuntimeException {

    private Class clazz;

    public NotFoundException(Class clazz, String objectType, String objectId) {
        super(MessageFormat.format("Could not find {0} with identifier {1}", objectType, objectId));
        this.clazz = clazz;
    }

    public Class getClazz() {
        return clazz;
    }
}
