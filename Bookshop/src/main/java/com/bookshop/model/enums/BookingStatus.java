package com.bookshop.model.enums;

import jakarta.persistence.*;


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
}
