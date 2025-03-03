package com.example.greetingapi.controller;

import com.example.greetingapi.model.Greeting;
import com.example.greetingapi.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

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

    @GetMapping("/service")
    public Greeting getGreetingFromService() {
        return new Greeting(greetingService.getGreetingMessage());
    }

    @GetMapping("/personalized")
    public Greeting getPersonalizedGreeting(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName) {

        String message = greetingService.getGreetingMessage(firstName, lastName);
        return new Greeting(message);
    }

    @PostMapping("/create")
    public Greeting createGreeting(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName) {

        return greetingService.saveGreeting(firstName, lastName);
    }

    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
}