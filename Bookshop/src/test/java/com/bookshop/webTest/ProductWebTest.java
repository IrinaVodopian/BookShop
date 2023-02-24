package com.bookshop.webTest;

import com.bookshop.TestConfigurationBookApp;
import com.bookshop.model.Product;
import com.bookshop.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.http.ResponseEntity.status;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;

@ActiveProfiles("test")
@SpringBootTest(classes = {TestConfigurationBookApp.class})
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class ProductWebTest {

	private String baseUri = "/product";

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	ProductRepository productRepository;

	Product product1 = new Product(1L, "Tale1", "goodBook", "H.H.Peterson", 10.0F, "http://path");
	Product product2 = new Product(2L, "Tale2", "goodBook", "H.H.Peterson", 10.0F, "http://path");

	@Test
	public void getAllProducts_success() throws Exception {
		List<Product> products = Arrays.asList(product1, product2);
		when(productRepository.findAll()).thenReturn(products);
		mockMvc.perform(MockMvcRequestBuilders
										.get(baseUri)
										.contentType(MediaType.APPLICATION_JSON))
						.andExpect(MockMvcResultMatchers.status().isOk())
						.andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
						.andExpect(MockMvcResultMatchers.jsonPath("$[0].productName", is("Tale1")));
	}

	@Test
	public void getProductById_success() throws Exception {
		when(productRepository.findById(1L)).thenReturn(Optional.ofNullable(product1));
		mockMvc.perform(MockMvcRequestBuilders
										.get("/product/{productId}", "1")
										.contentType(MediaType.APPLICATION_JSON))
						.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void saveProduct_success() throws Exception {
		Mockito.when(productRepository.save(product1)).thenReturn(product1);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(product1);

		mockMvc.perform(MockMvcRequestBuilders
										.post(baseUri)
										.contentType(MediaType.APPLICATION_JSON_VALUE)
										.content(requestJson))
						.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void deleteProductById_success() throws Exception {
		doNothing().when(productRepository).deleteById(1L);
		mockMvc.perform(MockMvcRequestBuilders
										.delete("/product/{productId}", "1")
										.contentType(MediaType.APPLICATION_JSON)
										.accept(MediaType.APPLICATION_JSON))
						.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
