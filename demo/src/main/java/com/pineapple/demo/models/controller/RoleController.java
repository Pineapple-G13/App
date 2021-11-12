
package com.pineapple.demo.models.controller;

import com.pineapple.demo.models.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/role")
public class RoleController {
    
     @Autowired
     private RoleService roleService;
     @GetMapping("/create")
     public ModelAndView create(){
     return new ModelAndView ("rol-formulario");//falta html
     
     }
     public RedirectView guardar(@RequestParam String roleName){
     roleService.create(roleName);
     return new RedirectView("/index");//redirige a la pagina principal falta html
     }
     
     
}
