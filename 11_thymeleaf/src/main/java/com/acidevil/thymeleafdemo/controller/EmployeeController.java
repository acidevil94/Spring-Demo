package com.acidevil.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acidevil.thymeleafdemo.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@GetMapping("/list")
	public String listEmployees(Model model) {

		List<Employee> result = new ArrayList<>();

		result.add(new Employee("Andrea", "Coluzzi", "coluzziandreajh@gmail.com"));
		result.add(new Employee("Simone", "Coluzzi", "simonecoluzzi96@gmail.com"));
		
		model.addAttribute("employees", result);

		return "list-employees";
	}

}
