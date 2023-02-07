package com.bookshop.enums;

import javax.persistence.*;

@Table(name = "Role")
@Entity
public enum Role {
	ADMIN,
	MANAGER,
	CUSTOMER;

	@Id
	@Column(name = "roleId", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;
}
