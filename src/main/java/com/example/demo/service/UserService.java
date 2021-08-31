package com.example.demo.service;

import com.example.demo.exception.InvalidCredentialsException;

public interface UserService {

	 
    String authenticate(String userName, String password) throws  InvalidCredentialsException;

	String otpValidation(String userName, int otp) throws InvalidCredentialsException;

}
