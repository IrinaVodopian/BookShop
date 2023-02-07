package com.bookshop.controller;

import com.bookshop.model.Product;
import com.bookshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Configuration
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	public ProductRepository productRepository;

	@GetMapping
	public List<Product> getListOfProduct() {
		return productRepository.findAll();
	}

	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}

	@PutMapping("/{id}")
	public Product editProduct(@RequestBody Product product, @PathVariable Integer productId) {
		return productRepository.save(product);
	}

	@DeleteMapping("/{id}")
	void deleteProduct(@PathVariable Integer productId) {
		productRepository.deleteById(productId);
	}



}
