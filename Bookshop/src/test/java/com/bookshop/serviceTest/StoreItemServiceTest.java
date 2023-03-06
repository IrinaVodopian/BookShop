package com.bookshop.serviceTest;

import com.bookshop.TestConfigurationBookApp;
import com.bookshop.model.Product;
import com.bookshop.model.StoreItem;
import com.bookshop.repository.StoreItemRepository;
import com.bookshop.service.StoreItemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {TestConfigurationBookApp.class})
@ExtendWith(SpringExtension.class)
public class StoreItemServiceTest {

	@Autowired
	StoreItemService storeItemService;

	@Autowired
	StoreItemRepository storeItemRepository;

	Product product = new Product(1L, "Tale1", "goodBook", "H.H.Peterson", 10.0F, "http://path");
	StoreItem storeItem = new StoreItem(1L, product, 2, 1, 3);

	@Test
	public void getStoreItemById_success() {
		Mockito.when(storeItemRepository.findById(1L)).thenReturn(Optional.ofNullable(storeItem));
		StoreItem storeItemReturned = storeItemService.getStoreItemById(1L);
		assertTrue(storeItemReturned.getStoreId() == 1);
		verify(storeItemRepository, times(1)).findById(1L);
	}

	@Test
	public void saveProduct_success() {
		Mockito.when(storeItemRepository.save(storeItem)).thenReturn(storeItem);
		StoreItem storeItemReturned = storeItemService.saveStoreItem(storeItem);
		Assertions.assertNotNull(storeItemReturned);
		verify(storeItemRepository, times(1)).save(storeItem);
	}

	@Test
	public void deleteStoreItemById_success() {
		doNothing().when(storeItemRepository).deleteById(1L);
		storeItemService.deleteStoreItemById(1L);
		verify(storeItemRepository, times(1)).deleteById(1L);
	}
}
