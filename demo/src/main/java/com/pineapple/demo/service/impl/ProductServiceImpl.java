package com.pineapple.demo.service.impl;

import com.pineapple.demo.commons.GenericServiceImpl;
import com.pineapple.demo.dao.api.ProductDaoApi;
import com.pineapple.demo.model.Product;
import com.pineapple.demo.service.api.ProductServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product, Long> implements ProductServiceApi {

    @Autowired
    private ProductDaoApi productDaoApi;

    @Override
    public CrudRepository<Product, Long> getDao() {
        return productDaoApi;
    }
}
