package com.acidevil.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acidevil.springdemo.entity.Customer;
import com.acidevil.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomer(Model model) {
		List<Customer> customers = this.customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		Customer customer = new Customer();

		model.addAttribute("customer", customer);
		return "add-customer";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {

		Customer customer = this.customerService.getCustomer(id);

		model.addAttribute("customer", customer);
		return "add-customer";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int id, Model model) {

		this.customerService.deleteCustomer(id);

		return "redirect:/customer/list";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {

		this.customerService.saveCustomer(customer);

		return "redirect:/customer/list";
	}

}
