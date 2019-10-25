package com.venus.fapbpm.aop;

import com.venus.fapbpm.definedException.RequestArgsErrException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 *  检查参数切面
 */
@Aspect
@Component
public class CheckArgsAspect {

    @Pointcut("execution(* com.venus.fapbpm.controller.*.*(..,org.springframework.validation.BindingResult,..))")
    public void checkController(){}

    /**
     * 检查请求参数是否合法
     * @param joinPoint
     * @throws Exception
     */
    @Before("checkController()")
    public void checkControllerArgs(JoinPoint joinPoint) throws Exception{
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult){
                BindingResult bindingResult = ((BindingResult) arg);
                if (bindingResult.hasErrors()){
                    String message = bindingResult.getFieldError().getDefaultMessage();
                    throw new RequestArgsErrException(message);
                }
            }
        }
        return;
    }
}
