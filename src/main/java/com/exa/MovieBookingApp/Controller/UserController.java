package com.exa.MovieBookingApp.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exa.MovieBookingApp.Entity.Customer;
import com.exa.MovieBookingApp.Entity.User;
import com.exa.MovieBookingApp.Exception.AccessForbiddenException;
import com.exa.MovieBookingApp.Exception.UserCreationError;
import com.exa.MovieBookingApp.Repository.CustomerRepository;
import com.exa.MovieBookingApp.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {


	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	UserService userService;
	

	@PostMapping("/adduser")
	public User addUser(@RequestBody User user)
			throws AccessForbiddenException, UserCreationError {
		
	
		
		logger.info("-----------------User Added---------------------");
		Customer cust=new Customer(user.getUsername(),null,null,null,user.getPassword());
		customerRepository.saveAndFlush(cust);
		user.setCustomer(cust);
		return userService.addUser(user);
	
	
}
}
