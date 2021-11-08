package com.pineapple.demo.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name="products")
public class Product implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idProduct;
    private String name;
    private Long idCategoryProduct;
    private String description;
    private Integer quantity;
    @Column(name = "unit_price")
    private Double unitPrice;
    private String picture;
    
    private static final long serialVersionUID = 1L;

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getIdCategoryProduct() {
		return idCategoryProduct;
	}

	public void setIdCategoryProduct(Long idCategoryProduct) {
		this.idCategoryProduct = idCategoryProduct;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
