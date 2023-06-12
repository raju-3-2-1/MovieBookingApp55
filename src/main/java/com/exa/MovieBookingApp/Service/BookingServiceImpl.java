package com.exa.MovieBookingApp.Service;
import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.exa.MovieBookingApp.Dto.CustomerBookingDto;
import com.exa.MovieBookingApp.Entity.Booking;
import com.exa.MovieBookingApp.Entity.Customer;
import com.exa.MovieBookingApp.Entity.ShowCycle;
import com.exa.MovieBookingApp.Entity.User;
import com.exa.MovieBookingApp.Exception.BookingNotFoundException;
import com.exa.MovieBookingApp.Exception.CustomerNotFoundException;
import com.exa.MovieBookingApp.Exception.SeatNotFoundException;
import com.exa.MovieBookingApp.Repository.BookingRepository;
import com.exa.MovieBookingApp.Repository.CustomerRepository;
import com.exa.MovieBookingApp.Repository.MovieRepository;
import com.exa.MovieBookingApp.Repository.ShowCycleRepository;
import com.exa.MovieBookingApp.Repository.UserRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private ShowCycleRepository showCycleRepository;
	
	@Autowired
private	UserRepository userRepository;
	
	@Autowired
private	MovieRepository movieRepository;

	@Autowired
private	CustomerRepository customerRepository;
//	public Booking addBooking(Booking booking, Integer userId,Integer showId) throws BookingNotFoundException{
//		
//		User user = new User();
//		ShowCycle show=new ShowCycle();
//		
//		if(showId!=null) {
//		
//				show=showCycleRepository.findById(showId).get();
//				show.setBooking(booking);
//				
//				booking.setShow(show);
//		}
//			bookingRepository.saveAndFlush(booking);
//			showCycleRepository.saveAndFlush(show);
//		return bookingRepository.findById(booking.getBookingId()).get();
//	}

	
	public List<Booking> viewBookingList() throws BookingNotFoundException{
		List<Booking> lst=bookingRepository.findAll();
		return lst;
		
		
	}

	@Override
	public Booking updateBooking(Booking booking) throws BookingNotFoundException{
		
			bookingRepository.saveAndFlush(booking);
		return bookingRepository.getOne(booking.getBookingId());
	}

	@Override
	public Booking cancelBooking(int bookingid) throws BookingNotFoundException{

	Booking b = bookingRepository.getOne(bookingid);
	bookingRepository.delete(b);
	return b;
	}
	
	@Override
	public Booking viewBooking(int bookingid) throws BookingNotFoundException{
		return bookingRepository.findById(bookingid).get();
	}
	
//booking the seat by user by checking if any seats are booked or not if seat gets booked then details would be saved successfully
 //	  else all the transactions(operations) gets rolled back.
	
//	@Transactional
   @Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
	public Booking seats(int seatNumber, int showid,CustomerBookingDto dto,int userid)throws SeatNotFoundException, CustomerNotFoundException{
		Customer custom=new Customer();
	   
	   customerRepository.save(dto.getCustomer());
	   ShowCycle show=new ShowCycle();
	   show=showCycleRepository.findById(showid).get();
		 validateCustomerSeatNumber(showid,seatNumber);
		 
//		if(showCycleRepository.findById(showid).get().getSeatsList().contains(seatNumber)) {
//			throw new SeatNotFoundException(".........seatnumber "+seatNumber+" booked......");
//		}
//		else {
		showCycleRepository.findById(showid).get().getSeatsList().add(seatNumber);
			dto.getBooking().setSeatNumber(seatNumber);
					show.setBooking(dto.getBooking());
					dto.getBooking().setSeatNumber(seatNumber);
					dto.getBooking().setShow(show);
					dto.getBooking().setCustomer(dto.getCustomer());
				
				bookingRepository.saveAndFlush(dto.getBooking());
				showCycleRepository.saveAndFlush(show);
		validatecustomer(userid, dto.getCustomer().getPassword());
//		}
		

		showCycleRepository.saveAndFlush(showCycleRepository.findById(showid).get());
		return bookingRepository.findById(dto.getBooking().getBookingId()).get();
	}
   
   
   public boolean validateCustomerSeatNumber(int showid, int seatNumber) throws SeatNotFoundException {
	   if(seatNumber>30)
		   throw new SeatNotFoundException("......... please select the seatNumber below 30........");
	   if(showCycleRepository.findById(showid).get().getSeatsList().contains(seatNumber)) {
		   throw new SeatNotFoundException(".........seatnumber "+seatNumber+" booked......");
		   
	   }
	   else 
		   return true;
	}

	public boolean validatecustomer(int id,String password) throws CustomerNotFoundException {
			   
					User use=userRepository.findById(id).get();
					if(use.getPassword().equals(password))
							   return true;
				    else
					   throw new CustomerNotFoundException("Invalid password");
		   }
	
	
}
