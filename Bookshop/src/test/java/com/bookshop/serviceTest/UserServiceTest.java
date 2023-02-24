package com.bookshop.serviceTest;

import com.bookshop.TestConfigurationBookApp;
import com.bookshop.model.enums.Role;
import com.bookshop.model.UserEntity;
import com.bookshop.repository.UserRepository;
import com.bookshop.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {TestConfigurationBookApp.class})
@ExtendWith(SpringExtension.class)
public class UserServiceTest {

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;
 	UserEntity user = new UserEntity(1L, "Piotr", Role.ADMIN, "gmail", "888", "street", "login", "password");

	@Test
	public void getUserById_success() {
		when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(user));
		UserEntity returnedUser = userService.getUserById(1L).orElse(null);
		assertNotNull(returnedUser);
		verify(userRepository, times(1)).findById(1L);
	}

	@Test
	public void saveUser_success() {
		when(userRepository.save(user)).thenReturn(user);
		UserEntity returnedUser = userService.createNewUser(user);
		Assertions.assertNotNull(returnedUser);
		verify(userRepository, times(1)).save(user);
	}

	@Test
	public void deleteUserById_success() {
		doNothing().when(userRepository).deleteById(1L);
		userService.deleteUser(1L);
		verify(userRepository, times(1)).deleteById(1L);
	}
}
