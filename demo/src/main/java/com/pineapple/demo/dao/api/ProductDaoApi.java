package com.pineapple.demo.dao.api;

import com.pineapple.demo.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDaoApi extends CrudRepository<Product, Long> {

}
