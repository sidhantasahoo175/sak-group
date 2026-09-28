package com.sak.sakgroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
   
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }
} 
