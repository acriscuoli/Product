package com.example.product.product;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	private final ProductRepository repository;
	ProductController(ProductRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/findAll")
	List<Product> all() {
		return repository.findAll();
	}
	
	@PostMapping("/save")
	Product newProduct(@RequestBody Product newProduct) {
		return repository.save(newProduct);
	}
	
	@GetMapping("/findById")
	Product one(@PathVariable Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException(id));		
	}
	
	
	@DeleteMapping("deleteById")
	void deleteProduct(@PathVariable Integer id) {
		repository.deleteById(id);
	}
	
	
	@PutMapping("/products/{id}")
	Product replaceProduct(@RequestBody Product newProduct, @PathVariable Integer id) {
		return repository.findById(id).map(product -> {
			product.setProduct(newProduct.getProduct());
			return repository.save(product);
		}).orElseGet(() -> {
			newProduct.setId(id);
			return repository.save(newProduct);
		});
	}

}
