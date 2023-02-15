package com.bookshop.model.enums;

import org.apache.catalina.User;

import jakarta.persistence.*;
import java.util.Set;

@Table(name = "Role")
@Entity
public enum Role {
	ADMIN,
	MANAGER,
	CUSTOMER;

	@Id
	@Column(name = "roleId", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;

//	@OneToMany(mappedBy="role")
//	private Set<User> users;
}
