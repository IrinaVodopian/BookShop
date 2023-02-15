package com.bookshop.service;

import com.bookshop.model.Booking;
import com.bookshop.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepository;

	public Optional<Booking> getBookingById(Long bookingId) {
		return bookingRepository.findById(bookingId);
	}

	public Booking createBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	public Booking editBooking(@RequestBody Booking booking, @PathVariable Long bookingId) {
		bookingRepository.deleteById(bookingId);
		return bookingRepository.save(booking);
	}

	public void cancelBooking(@PathVariable Long bookingId) {
		bookingRepository.deleteById(bookingId);
	}
}
