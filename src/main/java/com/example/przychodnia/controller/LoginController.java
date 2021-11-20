package com.example.przychodnia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
public class LoginController {

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(){
        return "logout";
    }
    
}
