package com.exa.MovieBookingApp.Exception;

public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public CustomerNotFoundException() {
	}

	public CustomerNotFoundException(String message) {
		super(message);
	}
}
