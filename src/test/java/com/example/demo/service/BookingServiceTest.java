package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.dto.BookingRequestDto;
import com.example.demo.entity.Booking;
import com.example.demo.entity.Days;
import com.example.demo.entity.Passengers;
import com.example.demo.entity.Train;
import com.example.demo.entity.User;
import com.example.demo.exception.NotBookedException;
import com.example.demo.exception.UserNotExistedException;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.TrainRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.serviceImpl.BookingServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {
	@Mock
	BookingRepository bookingRepository;

	@Mock
	UserRepository userRepository;

	@Mock
	TrainRepository trainRepository;

	@InjectMocks
	BookingServiceImpl bookingService;

	static User user;

	static Train train;

	static Days days;

	static Booking booking;

	static BookingRequestDto bookingRequestDto;
	static Passengers passengers;

	static List<Passengers> passengers1;

	@BeforeAll
	public static void setup() {
		user = new User();
		user.setMailId("achyuth065@gmail.com");
		user.setMobileNo("7995684808");
		user.setOtp(1234);
		user.setUserId(1L);
		user.setUserName("Achyuth065");

		train = new Train();
		train.setCost_single_seat(500);
		train.setDate(LocalDate.now());
		train.setDays(days.FRIDAY);
		train.setFromDestination("hyderabad");
		train.setPlatformNumber(7);
		train.setSeats(32);
		train.setToDestination("chennai");
		train.setTrainId(1L);
		train.setTrainName("chennai express");
		train.setTrainNumber(12345);

		passengers = new Passengers();
		passengers.setAadharNumber(353125141);
		passengers.setEmail("achyuth065@gmail.com");
		passengers.setGender("male");
		passengers.setName("Achyuth065");
		passengers.setSeatNumber(12);

		List<Passengers> passenger = new ArrayList<Passengers>();
		passenger.add(passengers);

		booking = new Booking();
		booking.setArrivalTime(LocalTime.of(6, 30));
		booking.setBookId(1L);
		booking.setDate(LocalDate.now());
		booking.setDepartureTime(LocalTime.of(10, 0));
		booking.setPassengers(passenger);
		booking.setPlatformNumber(train.getPlatformNumber());
		booking.setTotalPrice(passenger.size() * train.getCost_single_seat());
		booking.setTrain(train);
		booking.setUser(user);

	}

	@Test
	@DisplayName("History of Booking:Positive Booking")
	public void getTicketsbyId() throws UserNotExistedException, NotBookedException {
		List<Booking> b = new ArrayList<Booking>();
		b.add(booking);
		when(userRepository.existsById(1L)).thenReturn(true);
		when(bookingRepository.getTicketsbyId(1L)).thenReturn(b);
		List<Booking> result = bookingService.getTicketsbyId(1L);
		assertEquals(b, result);

	}

	@Test
	@DisplayName("History of Booking:Negative Booking")
	public void getTicketsbyId1() throws UserNotExistedException {

		when(userRepository.existsById(1L)).thenReturn(false);
		assertThrows(UserNotExistedException.class, () -> bookingService.getTicketsbyId(1L));

	}

}
