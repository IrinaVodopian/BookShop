package com.bookshop.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingEditCustomer {
	private Date date;
	private Time time;
	private String deliveryAddress;
}
