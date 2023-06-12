package com.exa.MovieBookingApp.Dto;

import com.exa.MovieBookingApp.Entity.Booking;
import com.exa.MovieBookingApp.Entity.Customer;

public class CustomerBookingDto {

	private Customer customer;
	
	private Booking booking;

	public CustomerBookingDto(Customer customer, Booking booking) {
		super();
		this.customer = customer;
		this.booking = booking;
	}
	
	public CustomerBookingDto() {
		
	}

	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
}
