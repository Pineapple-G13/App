package com.pineapple.demo.persistence;

import com.pineapple.demo.domain.Prod;
import com.pineapple.demo.domain.repository.ProdRepository;
import com.pineapple.demo.persistence.crud.ProductCrudRepository;
import com.pineapple.demo.persistence.entity.Product;
import com.pineapple.demo.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Operaciones CRUD desde la capa de persistencia.
 */
@Repository
public class ProductRepository implements ProdRepository {
	private ProductCrudRepository productCrudRepository;
	//Se implementa para enlazar con el mapper
	private ProductMapper mapper;

	/*
	 * Métodos para hacer el Repositorio Orientado a Dominio
	 * Los comentarios debajo representan los métodos tradicionales u originales.
	 */
	@Override
	public List<Prod> getAll(){
		List<Product> products = (List<Product>) productCrudRepository.findAll();
		return mapper.toProds(products);
	}
	//public List<Product> getAll(){ return productCrudRepository.findAll();}

	@Override
	public Optional<Prod> getByName(String name){
		return productCrudRepository.findByProductName(String name);
	}
	//public Optional<Prod> getByName(String name) {return Optional.empty();}

	/**
	 * Método para búsqueda de producto por medio de su Id
	 */
	@Override
	public Optional<Prod> getProduct(long idProd) {
		return productCrudRepository.findById(idProd).map(product -> mapper.toProd(product));
	}
	//public Optional<Product> getProduct(long idProduct){return productCrudRepository.findById(idProduct);}

	/**
	 * Guardar Producto
	 * @param prod El producto que entra por input
	 * @return producto
	 */
	@Override
	public Prod save(Prod prod) {
		Product product = mapper.toProduct(Prod prod);
		return mapper.toProd(productCrudRepository.save(product));
	}
	//public Product save(Product product){return productCrudRepository.save(product);}

	/**
	 * Eliminar Producto utilizando su clave primaria
	 */
	//public void delete(long idProduct){productCrudRepository.deleteById(idProduct);}
}
