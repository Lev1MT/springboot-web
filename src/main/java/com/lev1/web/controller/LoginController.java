package com.lev1.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

//    @ResponseBody
    @RequestMapping("/login")
    public String login(){
        return "index";
    }
}
