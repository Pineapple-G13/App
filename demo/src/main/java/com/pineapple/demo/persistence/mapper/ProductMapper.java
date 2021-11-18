package com.pineapple.demo.persistence.mapper;

import com.pineapple.demo.domain.Cat;
import com.pineapple.demo.domain.Prod;
import com.pineapple.demo.persistence.entity.Category;
import com.pineapple.demo.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProduct", target = "id"),
            @Mapping(source = "productName", target = "name"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "unitPrice", target = "price"),
            @Mapping(source = "category", target = "category"),
    })
    Prod toProd(Product product);
    List<Prod> toProds(List<Product> products);

    @InheritInverseConfiguration
    Product toProduct(Prod prod);

}
