//package com.components.controller;
//
//import org.apache.catalina.core.ApplicationContext;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//
///*
//доступ к аус данным успешно аутентифицированного юзера
// */
//
//@RestController
//@RequestMapping("/hello")
//public class MyController {
//
//    @GetMapping("/1")
//    public String root() {
//        UserDetails user = (UserDetails) SecurityContextHolder.getContext()
//                .getAuthentication().getPrincipal();
//        return "hello " + user.getUsername();
//    }
//
//    @GetMapping("/2") // req injection
//    public String root2(HttpServletRequest req) {
//        UserDetails user = (UserDetails) ((Authentication)req.getUserPrincipal()).getPrincipal();
//        return "hello " + user.getUsername();
//    }
//
//    @GetMapping("/3") // annotation
//    public String root3(@AuthenticationPrincipal UserDetails user) {
//        return "hello " + user.getUsername();
//    }
//
//    @GetMapping("/4") // any "extends principal" obj injection
//    public String root4(UsernamePasswordAuthenticationToken auth) {
//        return "hello " + auth.getName();
//    }
//}
