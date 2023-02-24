package com.bookshop.service;

import com.bookshop.helpers.BookingInfo;
import com.bookshop.model.Booking;
import com.bookshop.helpers.BookingPerCustomer;
import com.bookshop.model.Product;
import com.bookshop.model.UserEntity;
import com.bookshop.model.enums.BookingStatus;
import com.bookshop.repository.BookingRepository;
import com.bookshop.repository.ProductRepository;
import com.bookshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ProductRepository productRepository;

	public Optional<Booking> getBookingById(Long bookingId) {
		return bookingRepository.findById(bookingId);
	}

	public Booking createBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	public Booking editBooking(Booking booking, Long bookingId) {
		bookingRepository.deleteById(bookingId);
		return bookingRepository.save(booking);
	}

	public void cancelBooking(Long bookingId) {
		bookingRepository.deleteById(bookingId);
	}

	public List<Booking> getBookings() {
		return bookingRepository.findAll();
	}

	public Booking setStatus(BookingStatus status, Long bookingId) {
		Booking booking = bookingRepository.findById(bookingId).get();
		booking.setStatus(status);
		return bookingRepository.save(booking);
	}

	public List<Booking> getBookingPerUser(Long id) {
		return bookingRepository.findByUserUserId(id);
	}

	public Booking bookProductCustomer(BookingPerCustomer info) {
		UserEntity user = userRepository.findById(info.getUserId()).get();
		Product product = productRepository.findById(info.getProductId()).get();
		Booking booking = Booking.builder()
						.product(product)
						.user(user)
						.deliveryAddress(user.getAddress())
						.quantity(info.getQuantity())
						.status(BookingStatus.SUBMITTED)
						.build();
		return bookingRepository.save(booking);
	}

	public Booking editBookingCustomer(BookingInfo info, Long bookingId) {
		Booking booking = bookingRepository.findById(bookingId).get();
		booking.setDate(info.getDate());
		booking.setTime(info.getTime());
		booking.setDeliveryAddress(info.getDeliveryAddress());
		return bookingRepository.save(booking);
	}
}
