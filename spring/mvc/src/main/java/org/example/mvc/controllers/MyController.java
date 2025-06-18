package org.example.mvc.controllers;

import jakarta.servlet.http.HttpSession;
import org.example.mvc.models.MyCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*
в модель входит только модель; контроллер и вью взаимодействуют именно с ней
если вью нужны данные контекста / др источника, этот источник должен положить их в модель
 */

@Controller("/")
public class MyController {

    @GetMapping("/{userId}")
    public String getMyCar(@Autowired ConfigurableApplicationContext context,
                           @PathVariable String userId,
                           Model model,
                           HttpSession httpSession) {
        Long longUserId = Long.parseLong(userId);

        if (httpSession.isNew()) {
            httpSession.setAttribute("visitsCount", 1L);
        } else {
            httpSession.setAttribute("visitsCount", (Long) httpSession.getAttribute("visitsCount") + 1);
        }

        if (longUserId == 1L) {
            model.addAttribute("firstUser", "true");
        }

        MyCar myCar = context.getBeansOfType(MyCar.class).entrySet().stream().filter((entry) ->
                entry.getKey().equals(userId)).findFirst().orElse(null).getValue();
        model.addAttribute("userMyCar", myCar);
        return "car";
    }

    @PostMapping("/clean")
    public String getMyCar(@ModelAttribute MyCar myCar,
                           Model model) {

        return "clean";
    }

    @GetMapping("/clean")
    public String getMyCar(@RequestBody MyCar myCar) {
        return "clean";
    }
}
