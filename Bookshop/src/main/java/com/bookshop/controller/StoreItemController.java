package com.bookshop.controller;

import com.bookshop.model.StoreItem;
import com.bookshop.service.StoreItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/storeItem")
public class StoreItemController {

	@Autowired
	public StoreItemService storeItemService;

	@GetMapping("/{storeItemId}")
	public StoreItem getStoreItemById(@PathVariable Long storeItemId) {
		return storeItemService.getStoreItemById(storeItemId);
	}

	@PostMapping
	public StoreItem saveStoreItem(@RequestBody StoreItem storeItem) {
		return storeItemService.saveStoreItem(storeItem);
	}

	@PutMapping("/{storeItemId}")
	public StoreItem editStoreItem(@RequestBody StoreItem storeItem, @PathVariable Long storeItemId) {
		return storeItemService.editStoreItem(storeItem, storeItemId);
	}

	@DeleteMapping("/{storeItemId}")
	void deleteStoreItemById(@PathVariable Long storeItemId) {
		storeItemService.deleteStoreItemById(storeItemId);
	}

}
