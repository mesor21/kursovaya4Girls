package com.travelAgency.Kursovaya.controller;

import com.travelAgency.Kursovaya.entity.UserSystem;
import com.travelAgency.Kursovaya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Login {
    @Autowired
    UserService userService;


    @GetMapping("/signin")
    public String sedLogin(){
        return "signin";
    }

    @GetMapping("/signup")
    public String signup(){return "signup";}

    @PostMapping("/signup")
    public String addNewUsers(@ModelAttribute("userForm")@Validated UserSystem userForm, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "signup";
        }
        if(!userService.saveUser(userForm, userForm.getRoles().getRole())){//Он не может работать с ролью на прямую.
            // Нужно каким-то образом роль отправлять так, что б не задействовал entity так как в UserSysyem ролью является класс Role

            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }
        return "redirct:/";
    }
}
