package com.exa.MovieBookingApp.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	// handling specific exception
		@ExceptionHandler(CustomerNotFoundException.class)
		public ResponseEntity<?> customerNotFoundHandling(CustomerNotFoundException exception, WebRequest request){
			ErrorDetails errorDetails = 
					new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
			return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
		}

		// handling global exception
		
		@ExceptionHandler(Exception.class)
		public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request){
			ErrorDetails errorDetails = 
					new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
			return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		// handling specific exception
		@ExceptionHandler(SeatNotFoundException.class)
		public ResponseEntity<?> seatNotFoundHandling(SeatNotFoundException exception, WebRequest request){
			ErrorDetails errorDetails = 
					new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
			return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
		}
		
		// handling specific exception
				@ExceptionHandler(BookingNotFoundException.class)
				public ResponseEntity<?> bookingNotFoundHandling(BookingNotFoundException exception, WebRequest request){
					ErrorDetails errorDetails = 
							new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
					return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
				}
				
		
		// handling specific exception
		@ExceptionHandler(MovieNotFoundException.class)
		public ResponseEntity<?> movieNotFoundHandling(MovieNotFoundException exception, WebRequest request){
			ErrorDetails errorDetails = 
					new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
			return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
		}
		
	// handling specific exception
			@ExceptionHandler(ScreenNotFoundException.class)
			public ResponseEntity<?> screenNotFoundHandling(ScreenNotFoundException exception, WebRequest request){
				ErrorDetails errorDetails = 
						new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
				return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
			}
			
			// handling specific exception
			@ExceptionHandler(TheatreNotFoundException.class)
			public ResponseEntity<?> theatreNotFoundHandling(TheatreNotFoundException exception, WebRequest request){
				ErrorDetails errorDetails = 
						new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
				return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
			}
			
			// handling specific exception
			@ExceptionHandler(UserNotFoundException.class)
			public ResponseEntity<?> userNotFoundHandling(UserNotFoundException exception, WebRequest request){
				ErrorDetails errorDetails = 
						new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
				return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
			}
			
	// handling specific exception
				@ExceptionHandler(AccessForbiddenException.class)
				public ResponseEntity<?> AccessNotFoundHandling(AccessForbiddenException exception, WebRequest request){
					ErrorDetails errorDetails = 
							new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
					return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
				}
						
				
	
}
