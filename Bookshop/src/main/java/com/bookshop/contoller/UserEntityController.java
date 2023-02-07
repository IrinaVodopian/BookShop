package com.bookshop.contoller;

import com.bookshop.model.UserEntity;
import com.bookshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserEntityController {

	@Autowired
	UserRepository userRepository;

	@GetMapping
	UserEntity getUser(@PathVariable String userName) {
		return userRepository.findByUserName(userName);
	}

	@PostMapping
	UserEntity createNewUser(@RequestBody UserEntity user) {
		return userRepository.save(user);
	}

	//might be better to change the logic of providing name
	@PutMapping("/{id}")
	UserEntity editUserProfile(@RequestBody UserEntity user, @PathVariable String userId) {
		return userRepository.save(user);
	}

	@DeleteMapping("/{id}")
	void deleteUser(@PathVariable String userId) {
		userRepository.deleteById(userId);
	}

}
