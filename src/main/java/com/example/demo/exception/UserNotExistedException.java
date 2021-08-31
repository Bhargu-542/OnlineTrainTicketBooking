package com.example.demo.exception;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.example.demo.entity.Booking;

public class UserNotExistedException extends Exception {
	
	String message;

	 

    public UserNotExistedException(String message) {
        super(message);
        this.message = message;
    }

 

    public UserNotExistedException() {
        super();
    }


 

}
