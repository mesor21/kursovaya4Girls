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
@RequestMapping("/dispatcher")
public class Hotel {
    @Autowired
    HotelService hotelService;
    @GetMapping("")
    public String getAdminPage(Model model){
        model.addAttribute("allUsers", hotelService.getAllHotel());
        return "dispatchermenu";
    }

    @PostMapping("/acsept")
    public String acseptRent(@RequestParam(value = "roomId",required = false)String roomId){
        hotelService.acsept(roomId);
        return "redirect:/dispatcher";
    }
    @PostMapping("/denide")
    public String deniedRent(@RequestParam(value = "roomId",required = false)String roomId){
        hotelService.denide(roomId);
        return "redirect:/dispatcher";
    }

    //2) Сделать вид что он подтверждает и не подтвреждает
}
