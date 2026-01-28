package com.goutham.LMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DemoController {
    @GetMapping("/")
    public String myHome(){
        return "home";
    }
}
