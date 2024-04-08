package com.feliqe.springboot.app.aop.springbootaop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Order(2) - ordena los aspecoto para su ejecucion
@Order(2)
@Aspect
@Component
public class GreetingAspect {

    //registra eventos
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //se ejecutara antes  se indica donde antes de que
    // (..) : es una expresion irregular indicando que recibira cualquiera
    // com.feliqe.springboot.app.aop.springbootaop.services; :  se tiene que inidcar la rutay depsues el metodo
    //podemos indicar enves de String colocar un * tomara todo los formatos
    //se cambiamos los campos por * los de los nombre de la clase se ejecuta de la misma forma solo que toma a cualquier que este dentro de la ruta
    //indicamos la ruta pero sin el nombre de la class igual se usa
    @Before("GreetingServicePointcuts.greetingLoggerPointCut()")

    //JoinPoint : es un punto de union
    public void loggerBefore(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().getName();
        String arg = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes: " + method + " con los argumentos " + arg);
    }

    //se ejecute despues de los metodos simpre se ejecutara
    @After("GreetingServicePointcuts.greetingLoggerPointCut()")
    // JoinPoint : es un punto de union
    public void loggerAfter(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().getName();
        String arg = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues: " + method + " con los argumentos " + arg);
    }

    // @AfterReturning( - se ejecutara cuando se retornan cuando no se ejecuta un error
    //se revisa la visual en la consola
    @AfterReturning("GreetingServicePointcuts.greetingLoggerPointCut()")
    public void loggerAfterReturning(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().getName();
        String arg = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues de retornar: " + method + " con los argumentos " + arg);
    }

    // @AfterThrowing - se ejecutara cuando hallar una error
    // paso 0
    @AfterThrowing("GreetingServicePointcuts.greetingLoggerPointCut()")
    public void loggerAfterThrowing(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().getName();
        String arg = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues de lanzar la excepcion: " + method + " con los argumentos " + arg);
    }

    // @Around - manipulamos cuando se ejecuta y cuando hay error
    @Around("GreetingServicePointcuts.greetingLoggerPointCut()")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        Object result = null;
        try {
            //ejecutara si esta correcto 
            logger.info("El metodo " + method + "() con los parametros " + args);
            result = joinPoint.proceed();
            logger.info("El metodo " + method + "retorna el resulatdo: " + result);
            return result;
        } catch (Exception e) {
            //si hay un error se mostrara el mensaje en la consola
            logger.error("Error en la llamada del metodo " + method + "()");
            throw e;
        }
    }
}
