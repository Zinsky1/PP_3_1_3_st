package com.example.fel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    //everyone
    @GetMapping
    public String home(){
        return "home";
    }

    //logged people
    @GetMapping("/logged")
    public String auth() {
        return "redirect:/";
    }

    //only admins
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    //admins and users
    @GetMapping("/user")
    public String simp() {
        return "user";
    }




}
