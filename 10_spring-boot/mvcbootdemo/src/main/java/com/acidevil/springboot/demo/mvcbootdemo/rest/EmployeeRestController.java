package com.acidevil.springboot.demo.mvcbootdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acidevil.springboot.demo.mvcbootdemo.dao.EmployeeDAO;
import com.acidevil.springboot.demo.mvcbootdemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	
	private EmployeeDAO employeeDAO;
	
	
	@Autowired
	public EmployeeRestController( EmployeeDAO dao) {
		this.employeeDAO = dao;
	}
	
	
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return this.employeeDAO.findAll();
	}
}
