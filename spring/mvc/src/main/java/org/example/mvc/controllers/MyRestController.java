package org.example.mvc.controllers;

import org.example.mvc.models.MyCar;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
request body - из тела запроса
request param - из url запроса
request header - из заголовков

model attribute = ищет в запросе данные с использованием requestBody, pathVariable, requestParam
и кладет их в модель автоматически
 */

/*
responseBody = сериализация в джейсон
restController = @ResponseBody на каждом методе
responseEntity = @ResponseBody с более детальным контролем над возвращаемым респонзом

 */
@RestController
public class MyRestController {

    @GetMapping
    /*
    недостает required -> 400 bad request, недостает не required -> null
     */
    public String getMyCar(@RequestParam(required = false, defaultValue = "1") String userId, Model model) {
        return "car";
    }

    @GetMapping("/clean")
    public String getMyCar(@RequestBody MyCar myCar) {
        return "car";
    }
}
