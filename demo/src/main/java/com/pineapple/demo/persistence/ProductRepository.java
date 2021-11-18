package com.pineapple.demo.persistence;

import com.pineapple.demo.persistence.crud.ProductCrudRepository;
import com.pineapple.demo.persistence.entity.Product;

import java.util.List;

/**
 * Operaciones crud desde la capa de persistencia.
 */
public class ProductRepository {
	private ProductCrudRepository productCrudRepository;

	/**
	 * Método para obtener todos los productos
	 * @return
	 */
	public List<Product> getAll(){
		return productCrudRepository.findAll();
	}
}
