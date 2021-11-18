package com.pineapple.demo.persistence.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * Mappeado de la entidad product_categories, está relacionada con products
 * @author shelvaldes
 *
 */

@Entity
@Table(name = "categories")
public class Category implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_category")
	private Long idCategory;
	@Column(name = "category_name")
	private String categoryName;
	@OneToMany(mappedBy = "category")
	private List<Product> products;

	public Category() {
	}

	public Category(Long idCategory, String productCategoryName, List<Product> products) {
		this.idCategory = idCategory;
		this.categoryName = productCategoryName;
		this.products = products;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Long getIdCategory() {
		return idCategory;
	}

	// getters y setters

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	public String getProductCategoryName() {
		return categoryName;
	}

	public void setProductCategoryName(String productCategoryName) {
		this.categoryName = categoryName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

}
