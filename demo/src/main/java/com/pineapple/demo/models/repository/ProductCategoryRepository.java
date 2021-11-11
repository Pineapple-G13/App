
package com.pineapple.demo.models.repository;

import com.pineapple.demo.models.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    
}

