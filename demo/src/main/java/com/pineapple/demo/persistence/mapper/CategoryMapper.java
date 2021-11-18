package com.pineapple.demo.persistence.mapper;

import com.pineapple.demo.domain.Cat;
import com.pineapple.demo.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategory", target = "catId"),
            @Mapping(source = "categoryName", target = "category"),
    })
    Cat toCat(Category category);
    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Category toCategory(Cat cat);
}
