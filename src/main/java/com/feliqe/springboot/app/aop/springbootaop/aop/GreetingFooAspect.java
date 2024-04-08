package com.feliqe.springboot.app.aop.springbootaop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Order(1) - ordena los aspecoto para su ejecucion siendo el primero en entrar y el primero en salir
@Order(1)
@Component
@Aspect
public class GreetingFooAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Before("GreetingServicePointcuts.GreetingFooAspectPointCup()")
    public void loggerAfterReturning(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().getName();
        String arg = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes Primero: " + method + " invocado con los parametros " + arg);
    }

    //campos de salida de ejecucion
    @After("GreetingServicePointcuts.GreetingFooAspectPointCup()")
    public void loggerAfter(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().getName();
        String arg = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues Primero: " + method + " invocado con los argumentos " + arg);
    }
}
