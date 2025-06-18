package org.example.controllers;

import org.example.beans.MyCar;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class MyController {

    @GetMapping("/bare")
    public MyCar getCarBare() {
        return new MyCar("ford focus", "red");
    }

    /*
    просто дает больше контроля над респонзом
    если метод просто возвращает объект, то спринг создаст респонз объект за нас

    в частности здесь мы явно говорим отправить респонз со статусом="ок"
     */
    @GetMapping("/response")
    public ResponseEntity<MyCar> getCarResponse() {
        return ResponseEntity.ok(new MyCar("ford mustang", "blue"));
    }
}
