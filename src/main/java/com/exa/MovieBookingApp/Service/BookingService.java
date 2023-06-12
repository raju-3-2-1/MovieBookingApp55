package com.exa.MovieBookingApp.Service;



import com.exa.MovieBookingApp.Dto.CustomerBookingDto;
import com.exa.MovieBookingApp.Entity.Booking;
import com.exa.MovieBookingApp.Exception.BookingNotFoundException;
import com.exa.MovieBookingApp.Exception.CustomerNotFoundException;
import com.exa.MovieBookingApp.Exception.SeatNotFoundException;


public interface BookingService {

//	public Booking addBooking(Booking booking, Integer customerId,Integer showId) throws BookingNotFoundException;


	public Booking updateBooking(Booking booking) throws BookingNotFoundException;

	public Booking cancelBooking(int bookingid) throws BookingNotFoundException;

	  public boolean validateCustomerSeatNumber(int showid, int seatNumber) throws SeatNotFoundException;
	
	public Booking viewBooking(int bookingid) throws BookingNotFoundException;
	public boolean validatecustomer(int id,String password) throws CustomerNotFoundException;

	public Booking seats(int seatNumber, int showid,CustomerBookingDto dto,int userid)throws SeatNotFoundException,CustomerNotFoundException;
	
}
