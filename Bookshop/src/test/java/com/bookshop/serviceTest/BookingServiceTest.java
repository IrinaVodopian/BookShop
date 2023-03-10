package com.bookshop.serviceTest;

import com.bookshop.TestConfigurationBookApp;
import com.bookshop.model.enums.BookingStatus;
import com.bookshop.model.enums.Role;
import com.bookshop.model.Booking;
import com.bookshop.model.Product;
import com.bookshop.model.UserEntity;
import com.bookshop.repository.BookingRepository;
import com.bookshop.service.BookingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import java.sql.Time;
import java.util.Date;

@ActiveProfiles("test")
@SpringBootTest(classes = {TestConfigurationBookApp.class})
@ExtendWith(SpringExtension.class)
public class BookingServiceTest {

	@Autowired
	BookingService bookingService;

	@Autowired
	BookingRepository bookingRepository;

	Product product = new Product(1L, "Tale1", "goodBook", "H.H.Peterson", 10.0F, "http://path");
 	UserEntity user = new UserEntity(1L, "Piotr", Role.ADMIN, "gmail", "888", "street", "login", "password");
	Booking booking = new Booking(1L, product, user, "street", new Date(), new Time(120), BookingStatus.APPROVED, 1);

	@Test
	public void getBookingById_success() {
		when(bookingRepository.findById(1L)).thenReturn(Optional.ofNullable(booking));
		Booking returnedBooking = bookingService.getBookingById(1L).orElse(null);
		assertNotNull(returnedBooking);
		verify(bookingRepository, times(1)).findById(1L);
	}

	@Test
	public void saveProduct_success() {
		when(bookingRepository.save(booking)).thenReturn(booking);
		Booking returnedBooking = bookingService.createBooking(booking);
		Assertions.assertNotNull(returnedBooking);
		verify(bookingRepository, times(1)).save(booking);
	}

	@Test
	public void deleteProductById_success() {
		doNothing().when(bookingRepository).deleteById(1L);
		bookingService.cancelBooking(1L);
		verify(bookingRepository, times(1)).deleteById(1L);
	}
}
