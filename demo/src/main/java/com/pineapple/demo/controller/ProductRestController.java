package com.pineapple.demo.controller;

import com.pineapple.demo.model.Product;
import com.pineapple.demo.service.api.ProductServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/")
@CrossOrigin("*")
public class ProductRestController {

    @Autowired
    private ProductServiceApi productServiceApi;

    @GetMapping(value = "/all")
    public List<Product> getAll() {
        return productServiceApi.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public Product find(@PathVariable Long id) {
        return productServiceApi.get(id);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        Product obj = productServiceApi.save(product);
        return new ResponseEntity<Product>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id) {
        Product product = productServiceApi.get(id);
        if (product != null) {
            productServiceApi.delete(id);
        } else {
            return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

}