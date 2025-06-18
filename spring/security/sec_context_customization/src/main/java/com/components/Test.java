package com.components;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

    public static void main(String[] args) {

        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        System.out.println(b.encode("user1"));
        System.out.println(b.encode("user2"));
    }
}
