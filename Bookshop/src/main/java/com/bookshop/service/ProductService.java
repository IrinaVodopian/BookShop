package com.bookshop.service;

import com.bookshop.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
}
