
package com.pineapple.demo.models.repository;

import com.pineapple.demo.models.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
	
	@Modifying
	@Query("UPDATE ProductCategory c SET c.productCategoryName = :productCategoryName")
    void modify(@Param("productCategoryName") String productCategoryName);
    
}

