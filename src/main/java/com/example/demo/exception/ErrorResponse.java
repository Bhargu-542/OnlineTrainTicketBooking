package com.example.demo.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ErrorResponse {
	private String message;
    private int statuscode;
    private LocalDateTime dateTime;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
    
	private Map<String,String> errorMaps = new HashMap<String,String>();

	public Map<String, String> getErrorMaps() {
		return errorMaps;
	}

	public void setErrorMaps(Map<String, String> errorMaps) {
		this.errorMaps = errorMaps;
	}

}
