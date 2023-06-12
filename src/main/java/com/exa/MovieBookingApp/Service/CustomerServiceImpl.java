package com.exa.MovieBookingApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exa.MovieBookingApp.Entity.Customer;
import com.exa.MovieBookingApp.Exception.CustomerNotFoundException;
import com.exa.MovieBookingApp.Repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService{


	@Autowired
	private CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer addCustomer(Customer customer) throws CustomerNotFoundException {
		if (customer != null) {
			if (customerRepository.existsById(customer.getCustomerId())) {
				throw new CustomerNotFoundException("Customer " + customer.getCustomerId() + " is already Exists");
			}  else {
				customerRepository.saveAndFlush(customer);
			}
		}
		return customerRepository.getOne(customer.getCustomerId());
	}

	
	

	@Override
	public Customer removeCustomer(int customerid) {
		Customer c = customerRepository.findById(customerid).get();
		customerRepository.delete(c);
		return c;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
	
		System.out.println(customer.getCustomerId());
		customerRepository.saveAndFlush(customer);
		return customerRepository.getOne(customer.getCustomerId());
	}

	@Override
	public Customer viewCustomer(int customerid) {
		return customerRepository.findById(customerid).get();
	}

	
}
