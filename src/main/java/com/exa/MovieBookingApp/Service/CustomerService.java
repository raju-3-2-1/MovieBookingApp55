package com.exa.MovieBookingApp.Service;

import com.exa.MovieBookingApp.Entity.Customer;
import com.exa.MovieBookingApp.Exception.CustomerNotFoundException;


public interface CustomerService {


	public Customer addCustomer(Customer customer) throws CustomerNotFoundException;

	public Customer removeCustomer(int customerid);

	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;

	public Customer viewCustomer(int customerid);
}
