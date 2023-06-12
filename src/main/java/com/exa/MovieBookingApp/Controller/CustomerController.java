package com.exa.MovieBookingApp.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exa.MovieBookingApp.Entity.Customer;
import com.exa.MovieBookingApp.Exception.AccessForbiddenException;
import com.exa.MovieBookingApp.Exception.CustomerNotFoundException;
import com.exa.MovieBookingApp.Service.CustomerService;


@RequestMapping("/customer")
@RestController
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;
	@Autowired
	LoginController loginController;

	@PostMapping("/add")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer)
			throws CustomerNotFoundException, AccessForbiddenException {
		
		ResponseEntity<String> response = null;
		if (customer == null) {
			logger.error("-------------Please Enter Customer Values--------");
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			customer = customerService.addCustomer(customer);
			response = new ResponseEntity<>("Customer is Added", HttpStatus.CREATED);
			logger.info("----------------Customer Created------------------");
		}
		return response;
	}

	
	@DeleteMapping("/delete")
	public Customer removeCustomer(@RequestParam int customerId)
			throws CustomerNotFoundException, AccessForbiddenException {
		
		logger.info("----------------Customer Deleted Successfully--------------");
		return customerService.removeCustomer(customerId);
	}

	
	@PutMapping("/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer)
			throws CustomerNotFoundException, AccessForbiddenException {
		
		ResponseEntity<Customer> response = null;
		if (customer == null) {
			logger.error("Enter Customer Details");
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			customer = customerService.updateCustomer(customer);
			response = new ResponseEntity<>(customer, HttpStatus.OK);
			logger.info("--------------Customer Updated Successfully-----------------");
		}
		return response;
	}


	
	
	@GetMapping("/view/{customerId}")
	public ResponseEntity<Customer> viewACustomer(@PathVariable int customerId) throws CustomerNotFoundException {

		ResponseEntity<Customer> response = null;
		try {
			Customer movie = customerService.viewCustomer(customerId);
			response = new ResponseEntity<>(movie, HttpStatus.OK);
			logger.info("-------Movie With Movie id " + customerId + " Found---------");
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			throw new CustomerNotFoundException("Customer with " + customerId + " id dosen't exist");
		}
		return response;
		// return ResponseEntity.ok(moviesService.viewMovie(movieId));
	}
}
