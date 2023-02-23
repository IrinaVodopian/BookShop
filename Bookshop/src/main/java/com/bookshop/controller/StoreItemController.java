package com.bookshop.controller;

import com.bookshop.model.StoreItem;
import com.bookshop.service.StoreItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/storeItem")
public class StoreItemController {

	@Autowired
	public StoreItemService storeItemService;

	@GetMapping()
	public List<StoreItem> getStoreItems() {
		return storeItemService.getStoreItems();
	}

	@GetMapping("/{storeItemId}")
	public StoreItem getStoreItemById(@PathVariable Long storeItemId) {
		return storeItemService.getStoreItemById(storeItemId);
	}

	@PostMapping
	public StoreItem saveStoreItem(@RequestBody StoreItem storeItem) {
		return storeItemService.saveStoreItem(storeItem);
	}

	@PostMapping("/{productId}")
	public StoreItem saveStoreItemById(@PathVariable Long productId, @RequestBody StoreItem storeItem) {
		return storeItemService.saveStoreItemById(productId, storeItem);
	}

	@PutMapping("/{storeItemId}")
	public StoreItem editStoreItem(@RequestBody StoreItem storeItem, @PathVariable Long storeItemId) {
		return storeItemService.editStoreItem(storeItem, storeItemId);
	}

	@DeleteMapping("/{storeItemId}")
	void deleteStoreItemById(@PathVariable Long storeItemId) {
		storeItemService.deleteStoreItemById(storeItemId);
	}

	@DeleteMapping
	@Valid void deleteStores(@Valid @RequestBody Long[] ids) {
		storeItemService.deleteAllById(Arrays.asList(ids));
	}
}
