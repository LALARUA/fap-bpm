package com.venus.fapbpm.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 日志切面
 */
@Aspect
@Component
public class LogAspect {
    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);


    @Pointcut("execution(* com.venus.fapbpm.exceptionHandler.*.*(Exception))")
    public void exceptionLog(){}


    @Before("exceptionLog()")
    public void exceptionLog(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        for (Object o : args) {
            if (o instanceof Exception){
                Exception exception = ((Exception) o);
                String message = exception.getMessage();
                String localizedMessage = exception.getLocalizedMessage();
                logger.error(message+"\r\n"+localizedMessage);
            }
        }

    }
}
