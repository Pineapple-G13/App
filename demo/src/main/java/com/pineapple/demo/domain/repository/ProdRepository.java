package com.pineapple.demo.domain.repository;

import com.pineapple.demo.domain.Prod;
import com.pineapple.demo.persistence.crud.ProductCrudRepository;
import com.pineapple.demo.persistence.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProdRepository {
    /**
     * Método para obtener todos los productos
     * @return Todos los productos
     */
    List<Prod> getAll();
    /**
     * Método para la búsqueda por nombres coincidentes
     * @param name input de usuario
     * @return Producto según la cadena capturada por el formulario
     */
    Optional<Prod> getByName(String name);

    /**
     * Método para búsqueda de producto por medio de su Id
     */
    Optional<Prod> getProduct(long idProd);
    /**
     * Guardar Producto
     * @param prod El producto que entra por input
     * @return De momento no retorna nada
     */
    Product save(Product prod);

    /**
     * Eliminar Producto utilizando su clave primaria
     */
    void delete(long idProd);
}
