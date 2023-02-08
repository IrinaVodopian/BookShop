package com.bookshop.main.serviceTest;

import com.bookshop.model.Product;
import com.bookshop.repository.ProductRepository;
import com.bookshop.service.ProductService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class ProductServiceTest {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private Product product;

	@Test
	void getAllProducts_listIsReturned(){
		Product product1 = new Product(null, "Tale1", "goodBook", "H.H.Peterson", 10.0F, "http://path");
		Product product2 = new Product(null, "Tale2", "goodBook", "H.H.Peterson", 10.0F, "http://path");

		productRepository.saveAll(Arrays.asList(product1,product2));
		List<Product> productList = productService.getAllProducts();

	}

//	@Autowired
//	private MockMvc mvc;
//
//	@Test
//	public void getProductsTest() throws Exception {
//		mvc.perform(MockMvcRequestBuilders.get("/product").accept(MediaType.APPLICATION_JSON))
//						.andExpect(status().isOk());
////						.andExpect((ResultMatcher) jsonPath("$", hasSize(2)));
//	}
}
