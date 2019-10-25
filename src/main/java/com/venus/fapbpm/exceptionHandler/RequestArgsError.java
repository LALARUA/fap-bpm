package com.venus.fapbpm.exceptionHandler;

import com.venus.fapbpm.definedException.RequestArgsErrException;
import com.venus.fapbpm.pojo.ResponseEntity;
import com.venus.fapbpm.pojo.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RequestArgsError {
    @ExceptionHandler({RequestArgsErrException.class})
    public ResponseEntity checkRequestArgsError(RequestArgsErrException errException){
        final String errorMessage = errException.getMessage();
        ResponseEntity responseEntity = new ResponseEntity(StatusCode.ARGUMENT_ERROR);
        responseEntity.setData(errorMessage);
        return responseEntity;
    }
}
