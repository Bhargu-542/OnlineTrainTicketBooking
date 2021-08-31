package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookingRequestDto;
import com.example.demo.entity.Booking;
import com.example.demo.exception.NotBookedException;
import com.example.demo.exception.TrainNotExistedException;
import com.example.demo.exception.UserNotExistedException;
import com.example.demo.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	BookingService bookingService;

	@PostMapping("/tickets")
	public ResponseEntity<String> bookTicket(@RequestBody BookingRequestDto bookingRequestDto)
			throws UserNotExistedException, TrainNotExistedException {
		String response = bookingService.bookTicket(bookingRequestDto);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@GetMapping("/users/tickets/")
	public List<Booking> getTicketsbyId(@RequestParam long userId) throws UserNotExistedException, NotBookedException {
		return bookingService.getTicketsbyId(userId);
	}

}
