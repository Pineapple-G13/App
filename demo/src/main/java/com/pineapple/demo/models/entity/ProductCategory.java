package com.pineapple.demo.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="product_categories")
public class ProductCategory implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id_category")
	private Long idCategory;
	public Long getIdCategory() {
		return idCategory;
	}
	
	// getters y setters

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Column(name= "product_name")
	private String productName;
	

	private static final long serialVersionUID = 1L;
	
	

}
