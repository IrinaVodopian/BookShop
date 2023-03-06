package com.bookshop.webTest;

import com.bookshop.TestConfigurationBookApp;
import com.bookshop.model.Product;
import com.bookshop.model.StoreItem;
import com.bookshop.repository.StoreItemRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest(classes = {TestConfigurationBookApp.class})
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class StoreItemWebTest {

	private String baseUri = "/storeItem";

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	StoreItemRepository storeItemRepository;

	Product product = new Product(1L, "Tale1", "goodBook", "H.H.Peterson", 10.0F, "http://path");
	StoreItem storeItem = new StoreItem(1L, product, 2, 1, 3);


	@Test
	public void getStoreItemById_success() throws Exception {
		when(storeItemRepository.findById(1L)).thenReturn(Optional.ofNullable(storeItem));
		mockMvc.perform(MockMvcRequestBuilders
										.get("/storeItem/{storeItemId}", "1")
										.contentType(MediaType.APPLICATION_JSON)
										.characterEncoding("utf-8"))
						.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void saveStoreItem_success() throws Exception {
		when(storeItemRepository.save(storeItem)).thenReturn(storeItem);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(storeItem);

		mockMvc.perform(MockMvcRequestBuilders
										.post(baseUri)
										.contentType(MediaType.APPLICATION_JSON_VALUE)
										.content(requestJson)
										.characterEncoding("utf-8"))
						.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void deleteStoreItemById_success() throws Exception {
		doNothing().when(storeItemRepository).deleteById(1L);
		mockMvc.perform(MockMvcRequestBuilders
										.delete("/storeItem/{storeItemId}", "1")
										.contentType(MediaType.APPLICATION_JSON)
										.accept(MediaType.APPLICATION_JSON)
										.characterEncoding("utf-8"))
						.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
