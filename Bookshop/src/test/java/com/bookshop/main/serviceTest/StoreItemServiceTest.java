package com.bookshop.main.serviceTest;

import com.bookshop.model.Product;
import com.bookshop.model.StoreItem;
import com.bookshop.repository.ProductRepository;
import com.bookshop.repository.StoreItemRepository;
import com.bookshop.service.StoreItemService;
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

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class StoreItemServiceTest {

	@Autowired
	StoreItemService storeItemService;

	@Autowired
	StoreItemRepository storeItemRepository;

	Product product = new Product(1, "Tale1", "goodBook", "H.H.Peterson", 10.0F, "http://path");
	StoreItem storeItem = new StoreItem(1, product, 2, 1, 3);

	@Test
	public void getStoreItemById_success() {
		Mockito.when(storeItemRepository.findById(1)).thenReturn(Optional.ofNullable(storeItem));
		StoreItem storeItemReturned = storeItemService.getStoreItemById(1);
		assertTrue(storeItemReturned.getStoreId() == 1);
		verify(storeItemRepository, times(1)).findById(1);
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
		doNothing().when(storeItemRepository).deleteById(1);
		storeItemService.deleteStoreItemById(1);
		verify(storeItemRepository, times(1)).deleteById(1);
	}
}
