package com.bookshop.controller;

import com.bookshop.model.Booking;
import com.bookshop.model.UserEntity;
import com.bookshop.model.enums.BookingStatus;
import com.bookshop.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	BookingService bookingService;

	@GetMapping()
	List<Booking> getBookings() {
		return bookingService.getBookings();
	}

	@GetMapping("/{bookingId}")
	Optional<Booking> getBookingById(@PathVariable Long bookingId) {
		return bookingService.getBookingById(bookingId);
	}

	@PostMapping
	Booking createBooking(@RequestBody Booking booking) {
		return bookingService.createBooking(booking);
	}

	@PutMapping("/{bookingId}")
	Booking editBooking(@RequestBody Booking booking, @PathVariable Long bookingId) {
		return bookingService.editBooking(booking, bookingId);
	}

	@PutMapping("/status/{bookingId}")
	Booking setStatus(@RequestBody BookingStatus status, @PathVariable Long bookingId) {
		return bookingService.setStatus(status, bookingId);
	}

	@DeleteMapping("/{bookingId}")
	void cancelBooking(@PathVariable Long bookingId) {
		bookingService.cancelBooking(bookingId);
	}


}
