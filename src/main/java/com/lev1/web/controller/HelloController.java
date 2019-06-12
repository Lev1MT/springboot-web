package com.lev1.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
