package com.exa.MovieBookingApp.Exception;

public class AccessForbiddenException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AccessForbiddenException(String message) {
		super(message);
	}

}
