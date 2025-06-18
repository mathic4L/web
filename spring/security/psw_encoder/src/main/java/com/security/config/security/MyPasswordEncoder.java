package com.security.config.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
public class MyPasswordEncoder {

    //Spring Security по умолчанию для кодировки использует DelegatingPasswordEncoder
    // можно переопределить зарегистрировав соотв бин
    // закодированный пароль хранится в виде {id}encodedValue
    @Bean
    public PasswordEncoder passwordEncoder() {
        /*
        PE который содержит в себе карту всех существующих PE
        * */
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public PasswordEncoder passwordEncoderConfigured() {
        String idForEncode = "bcrypt";
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        encoders.put("noop", NoOpPasswordEncoder.getInstance());
        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());
        encoders.put("sha256", new StandardPasswordEncoder());
        PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder(idForEncode, encoders);
        // 1st param - запись, 2nd param - маппинг {id} при сопоставлении на ecoder'ы
        return passwordEncoder;
    }

    @Bean
    public CommandLineRunner runnerMatch() {
        return args -> {
            PasswordEncoder pe = passwordEncoderConfigured();
            // pe.matches("plainValue", "encodedValue");
            // нет {id} / id=null / на id нет отображения в карте -- IllArgException
            System.out.println(passwordEncoderConfigured().encode("123"));
        };
    }

    @Bean
    public CommandLineRunner runnerWithUser() {
        return args -> {
            // юзер хранится с хешированным паролем,
            // но пароли все равно остаются открытыми в памяти и в скомпилированном исходном коде
            // Поэтому это способ по-прежнему не считается безопасным.
            // В условиях производственного развёртывания следует хэшировать пароли во внешнем окружении.
            UserBuilder userBuilder = User.withDefaultPasswordEncoder(); // bcrypt по умолчанию
            UserBuilder users = User.withDefaultPasswordEncoder();
            UserDetails user = users
                    .username("user")
                    .password("password")
                    .roles("USER")
                    .build();
            UserDetails admin = users
                    .username("admin")
                    .password("password")
                    .roles("USER", "ADMIN")
                    .build();
        };
    }


}
