package com.bookshop.main;

import com.bookshop.controller.BookingController;
import com.bookshop.controller.ProductController;
import com.bookshop.controller.UserEntityController;
import com.bookshop.repository.BookingRepository;
import com.bookshop.repository.ProductRepository;
import com.bookshop.repository.StoreItemRepository;
import com.bookshop.repository.UserRepository;
import com.bookshop.service.BookingService;
import com.bookshop.service.ProductService;
import com.bookshop.service.StoreItemService;
import com.bookshop.service.UserService;
import org.mockito.Mockito;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Profile("test")
@Configuration
@EnableJpaRepositories
public class TestConfiguration {

	@Bean
	@Primary
	public ProductRepository productRepository() {
		return Mockito.mock(ProductRepository.class);
	}

	@Bean
	@Primary
	public BookingRepository bookingRepository() {
		return Mockito.mock(BookingRepository.class);
	}

	@Bean
	@Primary
	public UserRepository userRepository() {
		return Mockito.mock(UserRepository.class);
	}

	@Bean
	@Primary
	public StoreItemRepository storeItemRepository() {
		return Mockito.mock(StoreItemRepository.class);
	}

	@Bean
	public ProductService productService() {
		return new ProductService();
	}

	@Bean
	public BookingService bookingService() {
		return new BookingService();
	}

	@Bean
	public StoreItemService storeItemService() {
		return new StoreItemService();
	}

	@Bean
	public UserService userService() {
		return new UserService();
	}

	@Bean
	public ProductController productController() {
		return new ProductController();
	}

	@Bean
	public BookingController bookingController() {
		return new BookingController();
	}

	@Bean
	public UserEntityController userEntityController() {
		return new UserEntityController();
	}

}
