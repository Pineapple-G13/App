package com.pineapple.demo.persistence.mapper;

import com.pineapple.demo.domain.Prod;
import com.pineapple.demo.domain.repository.ProdRepository;
import com.pineapple.demo.persistence.crud.ProductCrudRepository;
import com.pineapple.demo.persistence.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PlatziEjemplo implements ProdRepository {
    private ProductCrudRepository productCrudRepository;
    private ProductMapper mapper;

    @Override
    public List<Prod> getAll() {
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return mapper.toProds(products);
    }


    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }
}
