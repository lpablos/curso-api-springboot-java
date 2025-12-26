package com.gevolution.curso.controllers;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HelloWorldRestController {
    @GetMapping(value = {"/hello", "/hw", "/hola"})
    public String helloWorld() {
        System.out.println("Hello World endpoint was called");
        return "Hello, World!";
    }
}
