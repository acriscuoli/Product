package com.example.product.product;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id @GeneratedValue
	private Integer id;
	private String product;
	
	
	public Product(String product) {
		super();
		this.product = product;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getProduct() {
		return product;
	}


	public void setProduct(String product) {
		this.product = product;
	}



	  @Override
	  public String toString() {
	    return "Product{" + "id=" + this.id + ", product='" + this.product + '\'' + '}';
	  }
	
	

}
