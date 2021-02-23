package com.acidevil.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acidevil.springdemo.dao.CustomerDAO;
import com.acidevil.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping("/list")
	public String listCustomer(Model model) {

		List<Customer> customers = this.customerDAO.getCustomers();

		model.addAttribute("customers", customers);

		return "list-customers";
	}
}
