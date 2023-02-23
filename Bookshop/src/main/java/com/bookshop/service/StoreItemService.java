package com.bookshop.service;

import com.bookshop.model.Product;
import com.bookshop.model.StoreItem;
import com.bookshop.repository.ProductRepository;
import com.bookshop.repository.StoreItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreItemService {

	@Autowired
	public StoreItemRepository storeItemRepository;

	@Autowired
	public ProductRepository productRepository;

	public StoreItem getStoreItemById(Long id) {
		return storeItemRepository.findById(id).orElse(null);
	}

	public StoreItem saveStoreItem(StoreItem storeItem) {
		return storeItemRepository.save(storeItem);
	}

	public StoreItem editStoreItem(StoreItem storeItem, Long storeItemId) {
		storeItemRepository.deleteById( storeItemId);
		return storeItemRepository.save(storeItem);
	}

	public void deleteStoreItemById(Long productId) {
		storeItemRepository.deleteById(productId);
	}

	public List<StoreItem> getStoreItems() {
		return storeItemRepository.findAll();
	}

	public void deleteAllById(List<Long> ids) {
		storeItemRepository.deleteAllById(ids);
	}

	public StoreItem saveStoreItemById(Long productId, StoreItem storeItem) {
		Product product = productRepository.findById(productId).get();
		storeItem.setProduct(product);
		return storeItemRepository.save(storeItem);
	}
}
