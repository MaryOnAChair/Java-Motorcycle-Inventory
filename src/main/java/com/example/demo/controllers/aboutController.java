package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class aboutController {
    @GetMapping("/about.html")
    public String showAbout(){
        return "about";
    }
}
