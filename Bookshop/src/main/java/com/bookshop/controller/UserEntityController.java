package com.bookshop.controller;

import com.bookshop.model.UserEntity;
import com.bookshop.model.enums.Role;
import com.bookshop.service.UserService;
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
	UserEntity createNewUser(@RequestBody UserEntity user) {
		if(user.getRole() == null){
			user.setRole(Role.CUSTOMER);
		}
		System.out.println(user.toString());
		return userService.createNewUser(user);
	}

	@PutMapping("/{userId}")
	UserEntity editUserProfile(@RequestBody UserEntity user, @PathVariable Long userId) {
		return userService.editUserProfile(user, userId);
	}

	@DeleteMapping("/{userId}")
	void deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
	}

}
