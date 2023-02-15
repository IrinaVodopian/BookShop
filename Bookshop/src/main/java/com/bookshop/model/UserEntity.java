package com.bookshop.model;

import com.bookshop.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "UserEntity")
@Entity
public class UserEntity {

	@Id
	@Column(name = "userId", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(name = "userName")
  private String userName;
	@ManyToOne
	@JoinColumn(name="roleId", nullable=false)
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
