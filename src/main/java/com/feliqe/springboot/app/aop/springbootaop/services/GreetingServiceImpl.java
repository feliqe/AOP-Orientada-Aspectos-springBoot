package com.feliqe.springboot.app.aop.springbootaop.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService{

    @Override
    public String sayHello(String person, String phrase) {
        // concatena los parametros
        String greeting = phrase + " " + person;
        System.out.println(greeting);
        return greeting;
    }

    //simular un error - paso 2
    @Override
    public String sayHelloError(String person, String phrase) {
        throw new RuntimeException("algun error");
    }
}
