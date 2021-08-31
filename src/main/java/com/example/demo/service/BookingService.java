package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.dto.BookingRequestDto;
import com.example.demo.entity.Booking;
import com.example.demo.entity.Passengers;
import com.example.demo.exception.NotBookedException;
import com.example.demo.exception.TrainNotExistedException;
import com.example.demo.exception.UserNotExistedException;

public interface BookingService {
	
	public String bookTicket(BookingRequestDto bookingRequestDto) throws UserNotExistedException, TrainNotExistedException ;

	public List<Booking> getTicketsbyId(long userId) throws UserNotExistedException, NotBookedException;



}
