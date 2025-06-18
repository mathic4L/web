package ru.me.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {

    @GetMapping("/greeting")
    public String greeting(@ModelAttribute(name = "name") String name) {
        return "greeting";
    }

    @GetMapping("/index")
    public String helloWorldController(@ModelAttribute(name = "name") String name) {
        return "greeting";
    }

}