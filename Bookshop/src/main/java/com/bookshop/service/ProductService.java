package com.bookshop.service;

import com.bookshop.model.Product;
import com.bookshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

	@Autowired
	public ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public Product editProduct(Product product, Long productId) {
		productRepository.deleteById(productId);
		return productRepository.save(product);
	}

	public void deleteProductById(Long productId) {
		productRepository.deleteById(productId);
	}
}
