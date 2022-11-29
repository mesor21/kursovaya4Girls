package com.travelAgency.Kursovaya.controller;

import com.travelAgency.Kursovaya.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/client")
public class Client {
    @Autowired
    HotelService hotelService;
    @GetMapping("")
    public String getAdminPage(Model model) {
        model.addAttribute("allUsers", hotelService.getAllHotel());
        return "clientmenu";
    }

    @PostMapping("/")
    public String rent(@RequestParam(value = "roomId",required = false)String roomId){
        hotelService.rent(roomId);
        return "redirect:/client";
    }
}
