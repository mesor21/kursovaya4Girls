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
@RequestMapping("/admin")
public class Admin {

    @Autowired
    HotelService hotelService;

    @GetMapping("")
    public String getAdminPage(Model model){
        model.addAttribute("allUsers", hotelService.getAllHotel());
        return "adminmenu";
    }

    @PostMapping("/addHotel")
    public String createHotel(@RequestParam(value = "name",required = false)String name, @RequestParam(value = "address",required = false)String address,@RequestParam(value = "numbercount",required = false)String numbercount){
        int coutnNumbers = Integer.parseInt(numbercount);
        hotelService.createNewHotel(name, address);
        hotelService.addNewRoom(coutnNumbers, name);
        return "redirect:/admin";
    }

    @PostMapping("/deleteHotel")
    public String deleteHotel(@RequestParam(value = "hotelId",required = false)String hotelId){
        hotelService.deleteByHotelId(hotelId);
        return "redirect:/admin";
    }

    @PostMapping("/deleteRoom")
    public String deleteRoom(@RequestParam(value = "roomId",required = false)String roomId){
        hotelService.deleteByRoomId(roomId);
        return "redirect:/admin";
    }
}
