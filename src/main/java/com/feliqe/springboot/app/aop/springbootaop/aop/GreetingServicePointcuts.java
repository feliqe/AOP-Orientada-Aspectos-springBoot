package com.feliqe.springboot.app.aop.springbootaop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//indicamos @Aspect realiza la asociacion para las demas hojas  de aspect con el nombre
@Aspect
@Component
//para optimizar la consultas de las rutas
public class GreetingServicePointcuts {

    // optimisar las rutas de GreetingAspect
    @Pointcut("execution(* com.feliqe.springboot.app.aop.springbootaop..*.*(..))")
    public void greetingLoggerPointCut() { }

    // optimisar las rutas de GreetingFooAspect
    @Pointcut("execution(* com.feliqe.springboot.app.aop.springbootaop..*.*(..))")
    public void GreetingFooAspectPointCup() { }
}
