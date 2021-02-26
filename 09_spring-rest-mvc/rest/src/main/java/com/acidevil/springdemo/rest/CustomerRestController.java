package com.acidevil.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acidevil.springdemo.entity.Customer;
import com.acidevil.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	// autowire the CustomerService
	@Autowired
	private CustomerService customerService;

	// add mapping for GET /customers
	@GetMapping("/customers")
	public List<Customer> getCustomers() {

		return customerService.getCustomers();

	}

	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer customer = this.customerService.getCustomer(customerId);
		if (customer == null) {
			throw new CustomerNotFoundException("Customer not found with ID: " + customerId);
		}
		return customer;
	}
	
	
	

}