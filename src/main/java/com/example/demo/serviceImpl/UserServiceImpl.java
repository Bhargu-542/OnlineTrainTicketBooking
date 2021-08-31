package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.exception.InvalidCredentialsException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	JavaMailSender javaMailSender;

	@Override
	public String authenticate(String userName, String password) throws InvalidCredentialsException {

		User user = userRepository.findByUserNameAndPassword(userName, password);

		if (user != null) {

			return "Login Success";
//			Random random = new Random();
//			int otp = random.nextInt();
//			user.setOtp(Math.abs(otp));
//			User user1 = userRepository.save(user);
//			SimpleMailMessage message = new SimpleMailMessage();
//			message.setFrom("srutichaturvedi8@gmail.com");
//			message.setTo(user.getMailId());
//			message.setSubject("OTP for Validation");
//			message.setText("OTP for Validation " + otp);
//			javaMailSender.send(message);
//			
//			return "User Name " + user1.getUserName();
		} else {
			throw new InvalidCredentialsException(
					"Invalid Credentials..!!Please Verify your Credentials and Try Again.");
		}

	}

	@Override
	public String otpValidation(String userName, int otp) throws InvalidCredentialsException {

		User user = userRepository.findByUserName(userName);

		if (user == null) {
			throw new InvalidCredentialsException("User doesn't Exists...");
		}
		if (otp == user.getOtp()) {
			return "OTP Validated Successfully";
		} else {
			throw new InvalidCredentialsException("Please Verify OTP...");
		}

	}

}
