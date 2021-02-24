package com.acidevil.springdemo.service;

import java.util.List;

import com.acidevil.springdemo.entity.Customer;

public interface CustomerService {

	
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);
}
