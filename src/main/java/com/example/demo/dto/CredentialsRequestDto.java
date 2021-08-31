package com.example.demo.dto;

import javax.validation.constraints.NotEmpty;

public class CredentialsRequestDto {

	@NotEmpty(message = "user Name should not be empty")
	private String userName;
	@NotEmpty(message = "password should not be Empty")
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
