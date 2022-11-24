package com.travelAgency.Kursovaya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class Administrator {
    @GetMapping("/")
    public String getAdminPage(){
        return "adminmenu";
    }
}
