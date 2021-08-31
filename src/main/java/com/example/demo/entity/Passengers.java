package com.example.demo.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Passengers {
	
	@NotNull(message = "name should not be null")
	private String name;
	
	@NotNull(message = "email should not be null")
	private String email;
	
	@NotNull(message = "seatNumber should not be null")
	private int seatNumber;
	
	@NotNull(message = "gender should not be null")
	private String gender;
	
	@NotNull(message = "aadhar Number should not be null")
	private long aadharNumber;

	public Passengers(@NotNull(message = "name should not be null") String name,
			@NotNull(message = "email should not be null") String email,
			@NotNull(message = "seatNumber should not be null") int seatNumber,
			@NotNull(message = "gender should not be null") String gender,
			@NotNull(message = "aadhar Number should not be null") long aadharNumber) {
		super();
		this.name = name;
		this.email = email;
		this.seatNumber = seatNumber;
		this.gender = gender;
		this.aadharNumber = aadharNumber;
	}

	public Passengers() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	
	
	
	

}
