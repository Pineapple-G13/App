package com.pineapple.demo.persistence.crud;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pineapple.demo.persistence.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends JpaRepository<Product, Long>{
    /**
     * JPA query para hacer la búsqueda por nombre
     * @param productName es un input de usuario
     * @return Producto por nombre
     */
    Optional<Product> findByProductName(String productName);

    //idProduct

}
