package com.bookshop.model;

import com.bookshop.model.enums.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Booking {
	@Id
	@Column(name = "bookingId", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long bookingId;

	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "userId")
	private UserEntity user;

	@Column(name = "deliveryAddress")
	private String deliveryAddress;

	@Column(name = "date")
	private Date date;

	@Column(name = "time")
	private Time time;

	@Enumerated(EnumType.STRING)
	private BookingStatus status;

	@Column(name = "quantity")
	private int quantity;

}
