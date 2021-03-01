package com.acidevil.springboot.demo.mvcbootdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acidevil.springboot.demo.mvcbootdemo.entity.Employee;
import com.acidevil.springboot.demo.mvcbootdemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService service) {
		this.employeeService = service;
	}

	@GetMapping("/employees")
	public List<Employee> findAll() {
		return this.employeeService.findAll();
	}

	@GetMapping("/employees/{employeId}")
	public Employee getEmployee(@PathVariable int employeId) {
		Employee employee = this.employeeService.findById(employeId);

		if (employee == null) {
			throw new RuntimeException("Employee ID not found: " + employeId);
		}

		return employee;
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(0);

		this.employeeService.save(employee);
		return employee;
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		this.employeeService.save(employee);
		return employee;
	}

	@DeleteMapping("/employees/{employeId}")
	public String deleteEmployee(@PathVariable int employeId) {
		Employee employee = this.employeeService.findById(employeId);

		if (employee == null) {
			throw new RuntimeException("Employee ID not found: " + employeId);
		}

		this.employeeService.deleteById(employeId);

		return "Successfully deleted";
	}

}
