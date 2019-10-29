package com.venus.fapbpm.aop;

import com.venus.fapbpm.utils.ExceptionUtils;
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
    private final static Logger logger = LoggerFactory.getLogger(Exception.class);

    @Pointcut("execution(* com.venus.fapbpm.exceptionHandler.*.*(Exception))")
    public void exceptionLog(){}

    @Before("exceptionLog()")
    public void exceptionLog(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        for (Object o : args) {
            if (o instanceof Exception){
                Exception exception = ((Exception) o);
                String message = ExceptionUtils.getStackTrace(exception);
                logger.error(message);
            }
        }

    }
}
