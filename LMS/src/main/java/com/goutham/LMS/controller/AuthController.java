package com.goutham.LMS.controller;

import com.goutham.LMS.entity.User;
import com.goutham.LMS.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AuthController {
    private UserService userService;
    public AuthController(UserService theUserService){
        userService=theUserService;
    }
    @GetMapping("/")
    public String myHome(){
        return "home";
    }
    @GetMapping("/showMyLoginPage")
    public String getLoginPage(){
        return "login";
    }
    @GetMapping("/showRegistrationPage")
    public String registrationPage(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }
    @PostMapping("/users/save")
    public String save(@ModelAttribute("user") User theUser){
        userService.save(theUser);

        return "redirect:/showMyLoginPage";
    }
}
