package com.example.demo.dto;

import javax.validation.constraints.NotEmpty;

public class ValidationCredentialsDto {

	@NotEmpty(message = "user Name should not be empty")
	private String userName;
	
//	@NotEmpty(message = "OTP should not be empty")
	private int otp;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}
}
