/*
package com.pineapple.demo.models.service;

import com.pineapple.demo.models.entity.Product;
import com.pineapple.demo.models.entity.ProductCategory;
import com.pineapple.demo.models.repository.ProductCategoryRepository;
import com.pineapple.demo.models.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Transactional
    public void create(String productName, String description, Integer quantity, Double unitPrice, String picture, ProductCategory productCategory) {
        Product product = new Product();

        product.setName(productName);
        product.setDescription(description);
        product.setQuantity(quantity);
        product.setUnitPrice(unitPrice);
        product.setPicture(picture);
        product.setProductCategory(productCategory);
        productRepository.save(product);
    }

    @Transactional
    public void modify(String productName, String description, Integer quantity, Double unitPrice, String picture, ProductCategory productCategory) {
        productRepository.modify(productName, description, quantity, unitPrice, picture, productCategory);
    }

    // @Transactional(readOnly = true)
    public List<Product> searchAll() {
        return productRepository.findAll();
    }

    // @Transactional(readOnly = true)
    public Product buscarPorId(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElse(null);
    }

    public Product searchByName(String productName) {
        Optional<Product> productOptional =
                Optional.ofNullable(productRepository.searchProductByName(productName));
        return productOptional.orElse(null);
    }

    @Transactional
    public void delete(Long id) {
        productRepository.deleteById(id);

    }

}
*/
