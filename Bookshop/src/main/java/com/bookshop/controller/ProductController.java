package com.bookshop.controller;

import com.bookshop.model.Product;
import com.bookshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	public ProductService productService;

		@GetMapping
	public List<Product> getListOfProduct() {
		return productService.getAllProducts();
	}

	@GetMapping("/{productId}")
	public Product getProductById(@PathVariable Long productId) {
		return productService.getProductById(productId);
	}


	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@PutMapping("/{productId}")
	public Product editProduct(@RequestBody Product product, @PathVariable Long productId) {
		return productService.editProduct(product, productId);
	}

	@DeleteMapping("/{productId}")
	void deleteProductById(@PathVariable Long productId) {
		productService.deleteProductById(productId);
	}

}
