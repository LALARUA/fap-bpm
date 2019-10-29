package com.venus.fapbpm.definedException;

/**
 * 请求参数异常
 */
public class RequestArgsErrException extends RuntimeException {
    public RequestArgsErrException(String message) {
        super(message);
    }
}
