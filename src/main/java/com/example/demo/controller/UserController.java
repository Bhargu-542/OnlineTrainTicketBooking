package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CredentialsRequestDto;
import com.example.demo.exception.InvalidCredentialsException;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/user/login")
	public ResponseEntity<String> login(@Valid @RequestBody CredentialsRequestDto credentialsRequestDto)
			throws InvalidCredentialsException {
		String userStr = userService.authenticate(credentialsRequestDto.getUserName(),
				credentialsRequestDto.getPassword());
		return new ResponseEntity<String>(userStr, HttpStatus.OK);
	}
}
