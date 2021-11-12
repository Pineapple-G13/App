/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pineapple.demo.models.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pineapple.demo.models.entity.Product;
import com.pineapple.demo.models.entity.ProductCategory;
import com.pineapple.demo.models.repository.ProductCategoryRepository;
import com.pineapple.demo.models.repository.ProductRepository;

/**
 *
 * @author Garcia
 */

@Service
public class ProductCategoryService {
	
	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional
	public void create(String productCategoryName) {
		ProductCategory productCategory = new ProductCategory();
		
		productCategory.setProductCategoryName(productCategoryName);
		productCategoryRepository.save(productCategory);
	}
	
	@Transactional
    public void modify(String productCategoryName) {
    productCategoryRepository.modify(productCategoryName);
    }
   // @Transactional(readOnly = true)
    public List<ProductCategory> searchAll() {
        return productCategoryRepository.findAll();
    }
   // @Transactional(readOnly = true)
    public ProductCategory buscarPorId(Long id) {
      Optional<ProductCategory> productCategoryOptional = productCategoryRepository.findById(id);
      return productCategoryOptional.orElse(null);
    }
    @Transactional
    public void delete(Long id){
    productCategoryRepository.deleteById(id);
    
    }
    
}
