package com.venus.fapbpm.utils;

import com.venus.fapbpm.pojo.ResponseEntity;
import com.venus.fapbpm.pojo.StatusCode;
import org.springframework.validation.BindingResult;

public class ResponseUtil {
    public static ResponseEntity argumentErrorResponse(BindingResult bindingResult){
        final String errorMessage = bindingResult.getFieldError().getDefaultMessage();
        ResponseEntity responseEntity = new ResponseEntity(StatusCode.ARGUMENT_ERROR);
        responseEntity.setData(errorMessage);
        return responseEntity;
    }
}
