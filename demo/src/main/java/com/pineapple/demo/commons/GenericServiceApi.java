package com.pineapple.demo.commons;

import java.io.Serializable;
import java.util.List;

/**
 * Esta clase puede reciclarse para hacer todas las operaciones CRUD comunes, de esta manera se ahorra código.
 * Se le llama trabajar con Generics.
 * T representa al objeto genérico
 * @Parm T: Type (Tipo de Objeto o Clase.
 * @Param ID: Común en  todas las entidades.
 * Créditos a este tutorial:
 * https://www.youtube.com/watch?v=d3lM3w0bl3A
 */
public interface GenericServiceApi<T, ID extends Serializable> {
    T save(T entity);
    void delete(ID id);
    T get(ID id);
    List<T> getAll();
}
