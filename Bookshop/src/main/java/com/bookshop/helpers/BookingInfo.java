package com.bookshop.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class BookingInfo {
	private Long userId;
	private Long productId;
	private int quantity;
}
