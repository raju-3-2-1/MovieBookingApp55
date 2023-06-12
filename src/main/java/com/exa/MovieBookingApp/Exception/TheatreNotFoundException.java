package com.exa.MovieBookingApp.Exception;

public class TheatreNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public TheatreNotFoundException() {
		
	}

	public TheatreNotFoundException(String message) {
		super(message);
	}
}
