package com.travelAgency.Kursovaya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hotel")
public class Hotel {
    @GetMapping("/")
    public String getHotelPage(){
        return "dispatchermenu";
    }
}
