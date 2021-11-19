package com.pineapple.demo.controller;

import com.pineapple.demo.model.Product;
import com.pineapple.demo.service.api.ProductServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductServiceApi productServiceApi;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("list", productServiceApi.getAll());
        return "index";
    }

    @GetMapping("/save/{id}")
    public String showSave(@PathVariable("id") Long id , Model model) {
        if(id != null && id != 0) {
            model.addAttribute("product", productServiceApi.get(id));
        }else {
            model.addAttribute("persona", new Product());
        }
        return "save";
    }

    @PostMapping("/save")
    public String save(Product product, Model model) {
        productServiceApi.save(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        productServiceApi.delete(id);

        return "redirect:/";
    }
}
