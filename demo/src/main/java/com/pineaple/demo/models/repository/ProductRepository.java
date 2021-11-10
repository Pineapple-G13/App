
package com.pineaple.demo.models.repository;

import com.pineapple.demo.models.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



    @Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
