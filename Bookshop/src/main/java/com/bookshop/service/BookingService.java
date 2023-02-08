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

	public Optional<Booking> getBookingById(Integer bookingId) {
		return bookingRepository.findById(bookingId);
	}

	public Booking createBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	//change, set correct id?
	public Booking editBooking(@RequestBody Booking booking, @PathVariable Integer bookingId) {
		bookingRepository.deleteById(bookingId);
		booking.setBookingId(bookingId);
		return bookingRepository.save(booking);
	}

	public void cancelBooking(@PathVariable Integer bookingId) {
		bookingRepository.deleteById(bookingId);
	}
}
