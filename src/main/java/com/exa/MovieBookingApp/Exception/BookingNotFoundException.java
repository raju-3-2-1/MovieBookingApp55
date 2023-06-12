package com.exa.MovieBookingApp.Exception;

public class BookingNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public BookingNotFoundException() {
	}

	public BookingNotFoundException(String message) {
		super(message);
	}
	
}
