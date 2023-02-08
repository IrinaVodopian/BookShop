package com.bookshop.controller;

import com.bookshop.model.UserEntity;
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
	Optional<UserEntity> getUserById(@PathVariable Integer userId) {
		return userService.getUserById(userId);
	}

	@PostMapping
	UserEntity createNewUser(@RequestBody UserEntity user) {
		return userService.createNewUser(user);
	}

	@PutMapping("/{userId}")
	UserEntity editUserProfile(@RequestBody UserEntity user, @PathVariable Integer userId) {
		return userService.editUserProfile(user, userId);
	}

	@DeleteMapping("/{userId}")
	void deleteUser(@PathVariable Integer userId) {
		userService.deleteUser(userId);
	}

}
