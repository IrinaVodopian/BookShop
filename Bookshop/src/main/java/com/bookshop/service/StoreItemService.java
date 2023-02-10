package com.bookshop.service;

import com.bookshop.model.StoreItem;
import com.bookshop.repository.StoreItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreItemService {

	@Autowired
	public StoreItemRepository storeItemRepository;

	public StoreItem getStoreItemById(Integer id) {
		return storeItemRepository.findById(id).orElse(null);
	}

	public StoreItem saveStoreItem(StoreItem storeItem) {
		return storeItemRepository.save(storeItem);
	}

	public StoreItem editStoreItem(StoreItem storeItem, Integer storeItemId) {
		storeItemRepository.deleteById( storeItemId);
		return storeItemRepository.save(storeItem);
	}

	public void deleteStoreItemById(Integer productId) {
		storeItemRepository.deleteById(productId);
	}
}
