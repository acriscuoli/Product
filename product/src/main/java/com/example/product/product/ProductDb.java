package com.example.product.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class ProductDb {
	
	private static final Logger log = LoggerFactory.getLogger(ProductDb.class);

	  @Bean
	  CommandLineRunner initDatabase(ProductRepository repository) {

	    return args -> {
	      log.info("Preloading " + repository.save(new Product("iphone")));
	      log.info("Preloading " + repository.save(new Product("mela")));
	    };
	  }

}
