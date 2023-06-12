package com.exa.MovieBookingApp.Exception;

public class SeatNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public SeatNotFoundException() {
	}

	public SeatNotFoundException(String message) {
		super(message);
	}
}
