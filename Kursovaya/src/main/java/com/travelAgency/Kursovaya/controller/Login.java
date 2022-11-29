package com.travelAgency.Kursovaya.controller;

import com.travelAgency.Kursovaya.entity.UserSystem;
import com.travelAgency.Kursovaya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Login {
    @Autowired
    UserService userService;

    @GetMapping("/signin")
    public String sendLogin(){
        return "signin";
    }

    @GetMapping("/signup")
    public String signup(){return "signup";}

    @PostMapping("/signup")
        public String addNewUsers(@RequestParam(value = "login",required = false)String login, @RequestParam(value = "fullName",required = false)String fullName,@RequestParam(value = "password",required = false)String password,@RequestParam(value = "role",required = false)String role){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if(!userService.saveUser(new UserSystem(role, fullName, login, bCryptPasswordEncoder.encode(password)))){
            return "redirect:/signup";
        }
        System.out.println("New user: "+fullName+"; login: "+login+" "+role);
        return "redirect:/signin";
    }

    @GetMapping("/data")
    public String ad1411(){return "signup2";}
    @PostMapping("/data")
    public String add(@RequestParam(value = "login",required = false)String login, @RequestParam(value = "fullName",required = false)String fullName,@RequestParam(value = "password",required = false)String password,@RequestParam(value = "role",required = false)String role){
        userService.ListAllUsers();
        return "redirect:/data";
    }
}
