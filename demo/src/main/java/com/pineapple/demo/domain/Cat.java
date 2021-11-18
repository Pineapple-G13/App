package com.pineapple.demo.domain;

/*
--------------------------------
La arquitectura que se utiliza aquí es orientada al dominio. Es una capa de seguridad extra que separa la base de
datos  y puede hacer las veces de traductor, sin exponer la estructura de la base de datos.

Note que todas las clases son casi copia al carbón de las entidades en la capa de persistencia
--------------------------------
 */

public class Cat {
    private long catId;
    private String category;

    //getters and setters
    public long getCatId() {
        return catId;
    }

    public void setCatId(long catId) {
        this.catId = catId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        category = category;
    }
}
