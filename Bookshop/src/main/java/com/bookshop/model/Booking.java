package com.bookshop.model;

import com.bookshop.model.enums.BookingStatus;
import com.bookshop.model.enums.Role;
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

	@ManyToOne
	@JoinColumn(name = "statusId", nullable=false)
	private BookingStatus status;

	@ManyToOne
	@JoinColumn(name="roleId", nullable=false)
	private Role role;

	@Column(name = "quantity")
	private int quantity;

}
