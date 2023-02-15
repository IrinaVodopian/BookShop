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
@Table(name = "Booking")
@Entity
@NoArgsConstructor
public class Booking {
	@Id
	@Column(name = "bookingId", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long bookingId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id", referencedColumnName = "productId")
	private Product product;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_entity_id", referencedColumnName = "userId")
	private UserEntity user;

	@Column(name = "deliveryAddress")
	private String deliveryAddress;

	@Column(name = "date")
	private Date date;

	@Column(name = "time")
	private Time time;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "status_id", referencedColumnName = "statusId")
	private BookingStatus status;

	@Column(name = "quantity")
	private int quantity;

}
