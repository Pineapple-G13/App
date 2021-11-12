package com.pineapple.demo.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="product_categories")
public class ProductCategory implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id_category")
	private Long idCategory;	
        @Column(name= "product_category_name")
	private String productCategoryName;
        @OneToMany(mappedBy="productCategory")
        private List<Product>products;

    public ProductCategory() {
    }

    public ProductCategory(Long idCategory, String productCategoryName, List<Product> products) {
        this.idCategory = idCategory;
        this.productCategoryName = productCategoryName;
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
		return productCategoryName;
	}


	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	

	private static final long serialVersionUID = 1L;
	
	

}
