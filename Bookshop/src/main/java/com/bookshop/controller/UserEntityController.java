package com.bookshop.controller;

import com.bookshop.model.UserEntity;
import com.bookshop.model.enums.Role;
import com.bookshop.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserEntityController {

	@Autowired
	UserService userService;

	@GetMapping("/{userId}")
	Optional<UserEntity> getUserById(@PathVariable Long userId) {
		return userService.getUserById(userId);
	}

	@PostMapping
	UserEntity createNewUser(@Valid @RequestBody UserEntity user) {
		if(user.getRole() == null){
			user.setRole(Role.CUSTOMER);
		}
		return userService.createNewUser(user);
	}

	@PutMapping("/{userId}")
	UserEntity editUserProfile(@RequestBody UserEntity user, @PathVariable Long userId) {
		return userService.editUserProfile(user, userId);
	}

	@PutMapping("/{userId}/{role}")
	UserEntity setUserRole(@PathVariable Long userId, Role role) {
		UserEntity user = userService.getUserById(userId).get();
		user.setRole(role);
		return userService.editUserProfile(user, userId);
	}


	@DeleteMapping("/{userId}")
	void deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
	}

}
