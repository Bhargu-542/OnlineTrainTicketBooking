package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.User;
import com.example.demo.exception.InvalidCredentialsException;
import com.example.demo.repository.UserRepository;
import com.example.demo.serviceImpl.UserServiceImpl;

@SpringBootTest
public class UserServiceTests {

	@Mock
	UserRepository userRepository;

	@InjectMocks
	UserServiceImpl serviceImpl;

	static User user;
	static User user1;

	@BeforeAll
	public static void setUp() {

		user = new User();
		user.setUserName("Komal");
		user.setPassword("ankita");
		user.setMailId("komal@gmail.com");
		user.setMobileNo("7903778287");
		user1 = new User();
		user1.setUserId(101);
		user1.setUserName("Komal");
		user1.setMobileNo("7903778028");
	}

	@Test
	@DisplayName("authentication : positive scenario")
	public void authenticationTest() throws InvalidCredentialsException {
		// context
		when(userRepository.findByUserNameAndPassword("Komal", "ankita")).thenReturn(user);
		// event
		String result = serviceImpl.authenticate("Komal", "ankita");
		// outcome
		assertEquals("Login Success", result);

	}

	@Test
	@DisplayName("authentication : negative scenario")
	public void authenticationTest1() {
		// context
		when(userRepository.findByUserNameAndPassword("pragati", "password")).thenReturn(null);
		// event and outcome
		assertThrows(InvalidCredentialsException.class, () -> serviceImpl.authenticate("pragati", "password"));
	}

}
