package com.bookshop.service;

import com.bookshop.model.UserEntity;
import com.bookshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public Optional<UserEntity> getUserById(Long id) {
		return userRepository.findById(id);
	}

	public UserEntity createNewUser(UserEntity user) {
		return userRepository.save(user);
	}

	public UserEntity editUserProfile(UserEntity user, Long userId) {
		userRepository.deleteById(userId);
		return userRepository.save(user);
	}

	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

	public List<UserEntity> getUsers() {
		return userRepository.findAll();
	}

	public void deleteAllById(List<Long> ids) {
		userRepository.deleteAllById(ids);
	}

	public UserEntity getUserByName(String userName) {
		return userRepository.findByUserName(userName);
	}
}
