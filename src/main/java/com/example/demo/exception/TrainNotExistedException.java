package com.example.demo.exception;

public class TrainNotExistedException extends Exception {
	String message;

	public TrainNotExistedException() {
		super();
	}

	public TrainNotExistedException(String message) {
		super(message);
		this.message = message;
	}

}
