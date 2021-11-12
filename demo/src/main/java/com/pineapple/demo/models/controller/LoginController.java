
package com.pineapple.demo.models.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @GetMapping("/login")
    public ModelAndView login(){
    return new ModelAndView("login");//falata agregar la vista login
    
    }
}
