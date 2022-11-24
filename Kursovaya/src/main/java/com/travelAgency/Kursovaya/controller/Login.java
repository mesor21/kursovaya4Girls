package com.travelAgency.Kursovaya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Login {
    @GetMapping("/signin")
    public String sedLogin(){
        return "signin";
    }


    @GetMapping("/signup")
    public String signup(){return "signup";}
}
