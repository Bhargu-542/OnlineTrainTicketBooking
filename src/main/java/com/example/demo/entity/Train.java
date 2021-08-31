package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Train {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long trainId;

	@NotNull(message = "train Number should not be empty")
	private long trainNumber;

	@NotNull(message = "train name should not be empty")
	private String trainName;

	@NotNull(message = "Source should not be empty")
	private String fromDestination;

	@NotNull(message = "Destination should not be empty")
	private String toDestination;

	@NotNull(message = "Cost should not be empty")
	private long cost_single_seat;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int platformNumber;

	@Enumerated(EnumType.STRING)
	private Days days;

	@NotNull(message = "Date should not be empty")
	private LocalDate date;

	private long seats;
	
	

	public Days getDays() {
		return days;
	}

	public void setDays(Days days) {
		this.days = days;
	}

	public long getTrainId() {
		return trainId;
	}

	public void setTrainId(long trainId) {
		this.trainId = trainId;
	}

	public long getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(long trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getFromDestination() {
		return fromDestination;
	}

	public void setFromDestination(String fromDestination) {
		this.fromDestination = fromDestination;
	}

	public String getToDestination() {
		return toDestination;
	}

	public void setToDestination(String toDestination) {
		this.toDestination = toDestination;
	}

	public long getCost_single_seat() {
		return cost_single_seat;
	}

	public void setCost_single_seat(long cost_single_seat) {
		this.cost_single_seat = cost_single_seat;
	}

//	public List<Day> getDay() {
//		return day;
//	}
//
//	public void setDay(List<Day> day) {
//		this.day = day;
//	}

	public long getSeats() {
		return seats;
	}

	public void setSeats(long seats) {
		this.seats = seats;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getPlatformNumber() {
		return platformNumber;
	}

	public void setPlatformNumber(int platformNumber) {
		this.platformNumber = platformNumber;
	}
	
	
	

}
