package com.lev1.springboot.controller;

import com.lev1.springboot.entities.User;
import com.lev1.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login/{id}")
    public User login(@PathVariable Integer id){
        return loginService.login(id);
    }

}
