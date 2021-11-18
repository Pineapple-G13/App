package com.pineapple.demo.domain;

import com.pineapple.demo.persistence.entity.Category;

/*
--------------------------------
La arquitectura que se utiliza aquí es orientada al dominio. Es una capa de seguridad extra que separa la base de
datos  y puede hacer las veces de traductor, sin exponer la estructura de la base de datos.

Note que todas las clases son casi copia al carbón de las entidades en la capa de persistencia. En un dado caso
permitiría cabiar de base de datos, aunque este no es el propósito del ejercicio actual.

Para poder lograr este mappeo se utiliza la dependencia MapStruct
--------------------------------
 */
public class Prod {

    //Aquí los atributos pueden o no llamarse igual que en el objeto homólogo de la capa de persistencia. Incluso
    // habría atributos que podrían omitirse para no exponer los datos
    private Long id;
    private String name;
    private String description;
    private Integer quantity;
    private Double price;
    private Category category;
}
