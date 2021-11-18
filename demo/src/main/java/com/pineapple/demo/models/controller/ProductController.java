package com.pineapple.demo.models.controller;

import com.pineapple.demo.models.entity.Product;
import com.pineapple.demo.models.entity.ProductCategory;
import com.pineapple.demo.models.entity.Users;
import com.pineapple.demo.models.repository.ProductRepository;
import com.pineapple.demo.models.service.ProductCategoryService;
import com.pineapple.demo.models.service.ProductService;
//import com.pineapple.demo.models.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
@RequestMapping("/productos")
public class ProductController {
     @Autowired
    private ProductService productService;
    
    @Autowired
    private ProductCategoryService categoryService;
    
    
     @GetMapping()
    public ModelAndView mostrar(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("products1");
        Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);

        if (flashMap != null) {
            mav.addObject("exito", flashMap.get("exito"));
            mav.addObject("error", flashMap.get("error"));
        }

        mav.addObject("products", productService.searchAll());
        return mav;
    }
      @GetMapping("/create")
    public ModelAndView create(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("products1");
        Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);

        if (flashMap != null) {
            mav.addObject("error", flashMap.get("error"));
            mav.addObject("libro", flashMap.get("libro"));
        } else {
            mav.addObject("product", new Product());
        }

        mav.addObject("category", categoryService.searchAll());
        mav.addObject("title", "Create product");
        mav.addObject("action", "guardar");
        return mav;
    }
      @PostMapping("/guardar")
    public RedirectView guardar(@RequestParam String productName,@RequestParam String description,@RequestParam Integer quantity,@RequestParam Double unitPrice,@RequestParam String picture,@RequestParam ProductCategory productCategory){
      productService.create(productName,description, quantity,unitPrice, picture, productCategory);
         return new RedirectView("/api");
    }
    @PostMapping("/eliminar/{id}")
    public RedirectView eliminar(@PathVariable Long id) {
        productService.delete(id);
        return new RedirectView("/api");
    }
    
    
    
   }
  //  @Autowired
   // private ProductService productService;
    //@Autowired
    //private ProductCategoryService productCategoryService;

    //public ModelAndView searchAll(){
      //  ModelAndView mav = new ModelAndView ("product");

        //List<Product> product = productService.searchAll();
        //mav.addObject("product", product);

        //return mav;
   

