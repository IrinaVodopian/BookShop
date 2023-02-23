package com.bookshop.controller;

import com.bookshop.model.Booking;
import com.bookshop.model.enums.BookingStatus;
import com.bookshop.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.bookshop.model.enums.BookingStatus.SUBMITTED;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	BookingService bookingService;

	@GetMapping()
	List<Booking> getAllBookings() {
		return bookingService.getBookings();
	}

	@GetMapping("/{bookingId}")
	Optional<Booking> getBookingById(@PathVariable Long bookingId) {
		return bookingService.getBookingById(bookingId);
	}

	@GetMapping("/{userId}")
	List<Booking> getBookingByUser(@PathVariable Long userId) {
		return bookingService.getBookingByUser(userId);
	}


	@PostMapping
	Booking createBooking(@RequestBody Booking booking) {
		if(booking.getStatus() == null){
			booking.setStatus(SUBMITTED);
		}
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
