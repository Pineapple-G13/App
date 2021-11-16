package com.pineapple.demo.models.controller;

import com.pineapple.demo.models.entity.Product;
import com.pineapple.demo.models.entity.Role;
import com.pineapple.demo.models.entity.Users;
import com.pineapple.demo.models.repository.ProductRepository;
import com.pineapple.demo.models.service.ProductCategoryService;
//import com.pineapple.demo.models.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @GetMapping("products")
    public List<Product> getProducts(){
        return this.productRepository.findAll();
   }
    /*@Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;

    public ModelAndView searchAll(){
        ModelAndView mav = new ModelAndView ("product");

        List<Product> product = productService.searchAll();
        mav.addObject("product", product);

        return mav;
    }*/
}
