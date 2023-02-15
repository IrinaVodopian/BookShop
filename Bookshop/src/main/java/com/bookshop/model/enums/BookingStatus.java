package com.bookshop.model.enums;

import com.bookshop.model.Booking;
import com.bookshop.model.UserEntity;
import jakarta.persistence.*;

import java.util.Set;


@Table(name = "BookingStatus")
@Entity
public enum BookingStatus {
	SUBMITTED,
	REJECTED,
	APPROVED,
	CANCELED,
	IN_DELIVERY,
	COMPLETED;

	@Id
	@Column(name = "statusId", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long statusId;

	@OneToMany(mappedBy="status")
	private Set<Booking> bookings;
}
