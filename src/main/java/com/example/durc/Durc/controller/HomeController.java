package com.example.durc.Durc.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String printInfo(){

            return "Hello Bangladesh!";
    }

    @GetMapping("/home")
    public String goHome(){
        return "This is home page";
    }

}
