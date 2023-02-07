package com.test;

import com.bookshop.contoller.ProductController;
import com.bookshop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

//@DataJpaTest
//@SpringBootTest
@Test
@ContextConfiguration(locations = { "classpath:spring-test-config.xml" })
class ProductRepositoryT extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	private ProductController productController;

//	@Test
//	public void getProductsTest() {
//
//	}

	@Test
	public void addProductTest() {
		Product product = Product.builder()
						.productName("Tale")
						.description("Good book")
						.author("P.P.Harison")
						.imagePath("Path")
						.price(10.0f)
						.build();

		productController.addProduct(product);
	}

//	@Test
//	public void editProductTest() {
//
//	}
//
//	@Test
//	public void deleteProductTest() {
//
//	}
}
