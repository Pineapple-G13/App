
package com.pineapple.demo.models.repository;

import com.pineapple.demo.models.entity.Product;
import com.pineapple.demo.models.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



    @Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
   @Modifying
    @Query("UPDATE Product p SET p.productName = :productName, p.description = :description,p.quantity = :quantity, p.unitPrice = :unitPrice, p.picture = :picture, p.productCategory = :productCategory WHERE p.id = :id")
    void modify(@Param("productName") String productName,@Param("description") String description,@Param("quantity") Integer quantity,@Param("unitPrice") Double unitPrice, @Param("picture")String picture,@Param("productCategory") ProductCategory productCategory);
}     

