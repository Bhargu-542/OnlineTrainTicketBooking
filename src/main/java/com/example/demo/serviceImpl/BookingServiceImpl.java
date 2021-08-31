package com.example.demo.serviceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BookingRequestDto;
import com.example.demo.entity.Booking;
import com.example.demo.entity.Passengers;
import com.example.demo.entity.Train;
import com.example.demo.entity.User;
import com.example.demo.exception.NotBookedException;
import com.example.demo.exception.TrainNotExistedException;
import com.example.demo.exception.UserNotExistedException;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.TrainRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	TrainRepository trainRepository;

	@Override
	public String bookTicket(BookingRequestDto bookingRequestDto)
			throws UserNotExistedException, TrainNotExistedException {
		User user = userRepository.findByUserId(bookingRequestDto.getUserId());
		Train train = trainRepository.findByTrainId(bookingRequestDto.getTrainId());
		List<Passengers> passengers = new ArrayList<Passengers>();
		if (user == null) {
			throw new UserNotExistedException("User Doesn't Exists....");
		}
		if (train == null) {
			throw new TrainNotExistedException("Train Doesn't Exists....");
		}
//		if(passengers.isEmpty()) {
//			throw new UserNotExistedException("Passenger should be added..for booking");
//		}
		if (user != null && train != null) {
			Booking booking = new Booking();
			booking.setUser(user);
			booking.setTrain(train);
			booking.setNoOfTickets(bookingRequestDto.getPassengers().size());
			booking.setPassengers(bookingRequestDto.getPassengers());
			booking.setDate(LocalDate.now());
			booking.setDepartureTime(LocalTime.of(6, 30));
			booking.setArrivalTime(LocalTime.of(10, 0));
			booking.setPlatformNumber(train.getPlatformNumber());
			booking.setTotalPrice(bookingRequestDto.getPassengers().size() * train.getCost_single_seat());
			bookingRepository.save(booking);
			return " Ticket booked succesfully" + booking.getPlatformNumber() + " " + booking.getArrivalTime() + " "
					+ booking.getDepartureTime() + " " + booking.getTotalPrice();

		} else {
			return "ticket not booked";
		}

	}

	@Override
	public List<Booking> getTicketsbyId(long userId) throws UserNotExistedException, NotBookedException {

		User user = userRepository.findByUserId(userId);
		if (!userRepository.existsById(userId)) {
			throw new UserNotExistedException("User doesn't existed");
		}
		List<Booking> booking = bookingRepository.getTicketsbyId(userId);
		if (!booking.isEmpty()) {
			return booking;
		} else {
			throw new NotBookedException("user is registered but not booked any tickets");
		}

	}
}
