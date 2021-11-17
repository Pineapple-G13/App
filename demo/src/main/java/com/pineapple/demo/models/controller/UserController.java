
package com.pineapple.demo.models.controller;

import com.pineapple.demo.models.entity.Role;
import com.pineapple.demo.models.entity.Users;
import com.pineapple.demo.models.service.RoleService;
import com.pineapple.demo.models.service.UserService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/users")
public class UserController {
    
     @Autowired
    private UserService userService;
     @Autowired
     private RoleService rolService;
     
      @GetMapping()
    public ModelAndView searchAll(){
        ModelAndView mav = new ModelAndView ("users");
        
        List <Users> users = userService.searchAll()  ;
        mav.addObject("users", users);
        
        return mav;
    }
//@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView mav = new ModelAndView("user-formulario");
        mav.addObject("user", new Users());
        mav.addObject("title", "Create user");
        mav.addObject("action", "guardar");
        mav.addObject("roles", rolService.searchall());
        return mav;
    }
//@PreAuthorize("hasRole('ADMIN')")
     @PostMapping("/guardar")
    public RedirectView guardar(@RequestParam String username,@RequestParam Long dni,@RequestParam String password,@RequestParam String email,@RequestParam String firstName,@RequestParam String lastName,@RequestParam Role role,@RequestParam Date fechaCreacion){
      userService.create(username,dni,password,email,firstName,lastName,role,fechaCreacion);
         return new RedirectView("/users");
         
    } 
    @GetMapping("/editar/{dni}")
     public ModelAndView editarUsuario(@PathVariable Integer dni) {
        ModelAndView mav = new ModelAndView("user-formulario");
        mav.addObject("user", userService.searchByDni(dni));
        mav.addObject("title", "Editar usuario");
        mav.addObject("action", "modificar");
        mav.addObject("roles", rolService.searchall());
        return mav;
     }
       @PostMapping("/modificar")
    //@PreAuthorize("hasRole('ADMIN')")
    public RedirectView modify(@RequestParam String username,@RequestParam String password,@RequestParam String email,@RequestParam String firstName,@RequestParam String lastName) {
        userService.modify(username,password, email, firstName, lastName);
        return new RedirectView("/users");
    }
 @PostMapping("/eliminar/{dni}")
    public RedirectView delete(@PathVariable Integer dni) {
        userService.delete(dni);
        return new RedirectView("/users");
    }
    
}
