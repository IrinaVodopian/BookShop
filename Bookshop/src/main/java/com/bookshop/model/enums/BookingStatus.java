package com.bookshop.model.enums;
import jakarta.persistence.*;

public enum BookingStatus {
	SUBMITTED,
	REJECTED,
	APPROVED,
	CANCELED,
	IN_DELIVERY,
	COMPLETED;
}
