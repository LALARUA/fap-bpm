package com.venus.fapbpm.exceptionHandler;

import com.venus.fapbpm.definedException.RequestArgsErrException;
import com.venus.fapbpm.pojo.ResponseEntity;
import com.venus.fapbpm.pojo.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.logging.Logger;

/**
 * 处理请求参数异常 直接返回错误信息给前端
 */
@RestControllerAdvice
public class DefinedExceptionHandler {
    @ExceptionHandler(value = RequestArgsErrException.class)
    public ResponseEntity checkRequestArgsError(RequestArgsErrException errException){
        final String errorMessage = errException.getMessage();
        ResponseEntity responseEntity = new ResponseEntity(StatusCode.ARGUMENT_ERROR);
        responseEntity.setData(errorMessage);
        return responseEntity;
    }
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity checkRequestArgsError(Exception e){
        return new ResponseEntity(StatusCode.ERROR);
    }
}
