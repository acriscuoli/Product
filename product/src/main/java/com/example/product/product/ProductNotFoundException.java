package com.example.product.product;

public class ProductNotFoundException extends RuntimeException{
	
	ProductNotFoundException(Integer id) {
	    super("Could not find product " + id);
	  }

}
