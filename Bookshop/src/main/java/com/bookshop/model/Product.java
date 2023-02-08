package com.bookshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Product")
@Entity
public class Product {
	@Id
	@Column(name = "productId", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer productId;

	@Column(name = "productName")
  private String productName;

	@Column(name = "description")
	private String description;

	@Column(name = "author")
	private String author;

	@Column(name = "price")
	private float price;

	@Column(name = "imagePath")
	private String imagePath;

}
