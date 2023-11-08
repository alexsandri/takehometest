package com.tugaslife.tugasapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/application")
public class AppController {
    @GetMapping
    public String application(){
        return "Welcome to Backend";
    }
    
}
