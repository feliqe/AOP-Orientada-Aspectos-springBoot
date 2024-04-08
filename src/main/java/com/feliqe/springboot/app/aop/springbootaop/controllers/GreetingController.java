package com.feliqe.springboot.app.aop.springbootaop.controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feliqe.springboot.app.aop.springbootaop.services.GreetingService;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting")
    public ResponseEntity<?> greeting() {

        //pasamos los parametros
        return ResponseEntity
                .ok(Collections.singletonMap("greeting", greetingService.sayHello("pepe", "Hola que tal!")));
    }

    //paso 3
    @GetMapping("/greeting-error")
    public ResponseEntity<?> greetingError() {
        // pasamos los parametros para el error
        return ResponseEntity
                .ok(Collections.singletonMap("greeting", greetingService.sayHelloError("pepe", "Hola que tal!")));
    }
}
