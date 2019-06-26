package com.yassir.scholary.frontmodule.exceptions.handlers;

import com.yassir.scholary.coremodule.exceptions.IllegalOperationException;
import com.yassir.scholary.coremodule.exceptions.NotFoundException;
import com.yassir.scholary.coremodule.utils.LogUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(value = IllegalOperationException.class)
    public void illegalOperationHandler(IllegalOperationException e) {
        LogUtils.error(e.getClazz(), e.getMessage());
    }

    @ExceptionHandler(value = NotFoundException.class)
    public void NotFoundHandler(NotFoundException e) {
        LogUtils.error(e.getClazz(), e.getMessage());
    }
}
