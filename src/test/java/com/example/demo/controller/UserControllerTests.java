package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.dto.CredentialsRequestDto;
import com.example.demo.entity.User;
import com.example.demo.exception.InvalidCredentialsException;
import com.example.demo.serviceImpl.UserServiceImpl;


@SpringBootTest
public class UserControllerTests {

	@Mock
	UserServiceImpl userService;
	
	@InjectMocks
	UserController userController;
	
	static User user;
	static CredentialsRequestDto credentialsRequestDto;
	static CredentialsRequestDto credentialsNegative;
	
	@BeforeAll
	public static void setUp() {
	user = new User();
	user.setUserName("Anu");
	user.setPassword("password");
	user.setMobileNo("8976542311");
	user.setMailId("anu@gmail.com");
	
	credentialsRequestDto = new CredentialsRequestDto();
	credentialsRequestDto.setUserName("Anu");
	credentialsRequestDto.setPassword("password");
	credentialsNegative = new CredentialsRequestDto();
	credentialsNegative.setUserName("Srishty");
	credentialsNegative.setPassword("sris");
	}
	
	@Test
	@DisplayName("Login Function: Positive Scenario")
	public void loginTest() throws InvalidCredentialsException  {
	//context
	when(userService.authenticate("Anu", "password")).thenReturn("Login Success");
	//event
	ResponseEntity<String> result = userController.login(credentialsRequestDto);
	//outcome
	assertEquals("Login Success", result.getBody());
	assertEquals(HttpStatus.OK, result.getStatusCode());
	}
	
	
	@Test
	@DisplayName("Login Function: Negative Scenario")
	public void loginTest2() throws InvalidCredentialsException  {
	//context
	when(userService.authenticate("Srishty", "sris")).thenThrow(InvalidCredentialsException.class);
	//event
	//outcome
	assertThrows(InvalidCredentialsException.class, ()->userController.login(credentialsNegative));
	}


}
