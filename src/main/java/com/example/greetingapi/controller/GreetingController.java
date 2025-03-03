package com.example.greetingapi.controller;

import com.example.greetingapi.model.Greeting;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public Greeting getGreeting() {
        return new Greeting("Hello, GET request received!");
    }

    @PostMapping
    public Greeting postGreeting() {
        return new Greeting("Hello, POST request received!");
    }

    @PutMapping
    public Greeting putGreeting() {
        return new Greeting("Hello, PUT request received!");
    }

    @DeleteMapping
    public Greeting deleteGreeting() {
        return new Greeting("Hello, DELETE request received!");
    }
}
