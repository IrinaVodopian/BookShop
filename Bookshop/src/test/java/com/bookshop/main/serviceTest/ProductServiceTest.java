package com.bookshop.main.serviceTest;

import com.bookshop.model.Product;
import com.bookshop.repository.ProductRepository;
import com.bookshop.service.ProductService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class ProductServiceTest {

	@Autowired
	ProductService productService;

	@Autowired
	ProductRepository productRepository;

	Product product1 = new Product(1L, "Tale1", "goodBook", "H.H.Peterson", 10.0F, "http://path");
	Product product2 = new Product(2L, "Tale2", "goodBook", "H.H.Peterson", 10.0F, "http://path");

	@Test
	public void getAllProducts_success() {
		List<Product> products = Arrays.asList(product1, product2);
		when(productRepository.findAll()).thenReturn(products);
		List<Product> returnedProducts = productService.getAllProducts();
		Assertions.assertEquals(2, returnedProducts.size());
		verify(productRepository, times(1)).findAll();
	}

	@Test
	public void getProductById_success() {
		Mockito.when(productRepository.findById(1L)).thenReturn(Optional.ofNullable(product1));
		Product product = productService.getProductById(1L);
		assertTrue(product.getProductId() == 1);
		verify(productRepository, times(1)).findById(1L);
	}

	@Test
	public void saveProduct_success() {
		Mockito.when(productRepository.save(product1)).thenReturn(product1);
		Product returnedProduct = productService.saveProduct(product1);
		Assertions.assertNotNull(returnedProduct);
		verify(productRepository, times(1)).save(product1);
	}

	@Test
	public void deleteProductById_success() {
		doNothing().when(productRepository).deleteById(1L);
		productService.deleteProductById(1L);
		verify(productRepository, times(1)).deleteById(1L);
	}
}
