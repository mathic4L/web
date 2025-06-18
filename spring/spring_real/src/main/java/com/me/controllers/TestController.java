package com.me.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

    @GetMapping("/input")
    public String hello() {
        return "/input";
    }
    @PatchMapping("/output")
    public String goodbye(@ModelAttribute("a") String a) {
        return "/output";
    }
}
