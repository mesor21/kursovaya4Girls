package com.travelAgency.Kursovaya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Administrator {
    @GetMapping("/admin/admin")
    public String getAdminPage(){
        return "adminmenu";
    }//
}
