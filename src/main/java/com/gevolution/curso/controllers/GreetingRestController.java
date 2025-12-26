package com.gevolution.curso.controllers;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class GreetingRestController {

    @GetMapping({"/saludo/{name}", "/hola/{name}"})
    public String greeting(@PathVariable String name) {
        return "Hola "+name;
    }
}
