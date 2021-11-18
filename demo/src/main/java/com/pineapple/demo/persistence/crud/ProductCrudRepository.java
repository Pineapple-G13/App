package com.pineapple.demo.persistence.crud;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pineapple.demo.persistence.entity.Product;

import java.util.List;

public interface ProductCrudRepository extends JpaRepository<Product, Long>{
    List<Product> findByProductName(long productName);

            //idProduct

}
