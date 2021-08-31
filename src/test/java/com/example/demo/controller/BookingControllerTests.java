package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.example.demo.dto.BookingRequestDto;
import com.example.demo.entity.Booking;
import com.example.demo.entity.Days;
import com.example.demo.entity.Passengers;
import com.example.demo.entity.Train;
import com.example.demo.entity.User;
import com.example.demo.exception.NotBookedException;
import com.example.demo.exception.TrainNotExistedException;
import com.example.demo.exception.UserNotExistedException;
import com.example.demo.service.BookingService;

@SpringBootTest
public class BookingControllerTests {

	@Mock
	BookingService iBookingService;
	
	@InjectMocks
	BookingController bookingController;
	
	static Train train;
	static User user;
	static Booking booking;
	static List<Booking> bookingList;
	static List<BookingRequestDto> bookingDtoList;
	static BookingRequestDto bookingRequestDto;
	@BeforeAll
	public static void setUp() {
			
		    user=new User();
		    user.setUserName("sruti");
		    user.setPassword("sruti@123");
		    user.setMailId("sruti@gmail.com");
		    user.setMobileNo("8788999988");
		   	        
			train=new Train();
	        train.setTrainId(1);
	        train.setTrainName("saptagiri");
	        train.setTrainNumber(45248);
	        train.setFromDestination("hyderabad");
	        train.setToDestination("bangalore");
	        train.setDays(Days.MONDAY);
	        train.setCost_single_seat(300);
	        train.setSeats(500);
	        
	        List<Passengers> passengerList=new ArrayList<Passengers>();
	        passengerList.add(new Passengers("sruti", "sruti@gmail.com",22, "female", 678298982987l));
	        passengerList.add(new Passengers("sruti1", "srut1i@gmail.com",27, "female", 678298978987l));
	               
	        booking=new Booking();
	        booking.setBookId(1l);
	        booking.setDate(LocalDate.now());
	        booking.setTotalPrice(1200);
	        booking.setTrain(train);
	        booking.setUser(user);
	        booking.setPassengers(passengerList);   

	}
	
	@Test
	@DisplayName("AddBookingTrain :Positive Scenario")
	public void testAddBooking3() throws UserNotExistedException, TrainNotExistedException  {
		when(iBookingService.bookTicket(bookingRequestDto)).thenReturn("booking done successfully");
		ResponseEntity<String> result= bookingController.bookTicket(bookingRequestDto);
		assertEquals("booking done successfully",result.getBody());

	}
	
	
	@Test
	@DisplayName("AddBooking :Negative Scenario")
	public void testAddBooking4() throws Exception {
		when(iBookingService.bookTicket(bookingRequestDto)).thenThrow(UserNotExistedException.class);
		assertThrows(UserNotExistedException.class, ()->bookingController.bookTicket(bookingRequestDto));

	}
	
	@Test
	@DisplayName("get history: positive case")
	public void history() throws UserNotExistedException, NotBookedException  {
		
		when(iBookingService.getTicketsbyId(1L)).thenReturn(bookingList);
		
		assertEquals(bookingDtoList,bookingController.getTicketsbyId(1L));
	}
	
	@Test
	@DisplayName("get history: negative case")
	public void history1() throws UserNotExistedException, NotBookedException {
		
		when(iBookingService.getTicketsbyId(1L)).thenThrow(UserNotExistedException.class);
		
		assertThrows(UserNotExistedException.class,()->bookingController.getTicketsbyId(1L));
	}
}
