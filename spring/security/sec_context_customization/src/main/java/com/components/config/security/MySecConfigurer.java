package com.components.config.security;

import lombok.Data;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

/*
T - класс использования
P -класс построителя секьюрити контекста
 */

@Data
public class MySecConfigurer extends AbstractHttpConfigurer<MySecConfigurer, HttpSecurity> {

    private String realmName;
    /*
    метод специально возвращает тот же объект, чтобы можно было вызывать цепочки
     */
    public MySecConfigurer realmName(String realmName) {
        this.realmName = realmName;
        return this;
    }

    @Override
    public void init(HttpSecurity builder) throws Exception {
        builder.httpBasic((httpBasic) -> {httpBasic.realmName(this.realmName);
                })
                .authorizeHttpRequests().anyRequest().authenticated();
    }

    /*
    в конфиге уже нельзя добавлять (в ините можно) конфиги безопасности
    но на момент его использования уже есть AuthenticationManager в конфиге безопасности
     */
    @Override
    public void configure(HttpSecurity builder) throws Exception {
        super.configure(builder);
    }

}
