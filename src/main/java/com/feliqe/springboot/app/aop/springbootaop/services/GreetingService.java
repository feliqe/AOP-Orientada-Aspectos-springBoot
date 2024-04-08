package com.feliqe.springboot.app.aop.springbootaop.services;

public interface GreetingService {

    String sayHello(String person, String phrase);

    //simular un error - paso 1
    String sayHelloError(String person, String phrase);

}
