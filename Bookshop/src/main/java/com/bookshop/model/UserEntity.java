package com.bookshop.model;

import com.bookshop.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
@AllArgsConstructor
@Data
@Table(name = "UserEntity")
@Entity
public class UserEntity {

	@Id
	@Column(name = "userId", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	@Column(name = "userName")
  private String userName;

	//@Enumerated(EnumType.ORDINAL)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id", referencedColumnName = "roleId")
	private Role role;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "address")
	private String address;

	@Column(name = "login")
	private String login;

	@Column(name = "password")
	private String password;
}
