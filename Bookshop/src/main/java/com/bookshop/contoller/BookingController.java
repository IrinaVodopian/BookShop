package com.bookshop.contoller;

import com.bookshop.model.Booking;
import com.bookshop.repository.BookingRepository;
import com.bookshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	ProductService productService;

	@GetMapping("/{id}")
	Optional<Booking> getBooking(@PathVariable Integer bookingId) {
		return bookingRepository.findById(bookingId);
	}

	@PostMapping
	Booking createBooking(@RequestBody Booking booking) {
		return bookingRepository.save(booking);
	}

	@PutMapping("/{id}")
	Booking editBooking(@RequestBody Booking booking, @PathVariable Integer bookingId) {
		return bookingRepository.save(booking);
	}

	@DeleteMapping("/{id}")
	void cancelBooking(@PathVariable Integer bookingId) {
		bookingRepository.deleteById(bookingId);
	}


}
