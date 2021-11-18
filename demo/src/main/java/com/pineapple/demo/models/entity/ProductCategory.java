package com.pineapple.demo.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class ProductCategory implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(nullable = false)
	private Long id;	
        @JoinColumn(nullable = false)
	private String productCategoryName;
        @OneToMany(mappedBy="productCategory")
        private List<Product>products;

    public ProductCategory() {
    }

    public ProductCategory(Long id, String productCategoryName, List<Product> products) {
        this.id= id;
        this.productCategoryName = productCategoryName;
        this.products = products;
    }

        
        
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
	public Long getId() {
		return id;
	}
	
	// getters y setters

	public void setId(Long id) {
		this.id= id;
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
