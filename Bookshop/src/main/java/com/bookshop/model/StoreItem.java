package com.bookshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "StoreItem")
@Entity
public class StoreItem {
	@Id
	@Column(name = "storeId", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long storeId;

	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;

	@Column(name = "availableQty")
	private int availableQty;

	@Column(name = "bookedQty")
	private int bookedQty;

	@Column(name = "soldQty")
	private int soldQty;
}
