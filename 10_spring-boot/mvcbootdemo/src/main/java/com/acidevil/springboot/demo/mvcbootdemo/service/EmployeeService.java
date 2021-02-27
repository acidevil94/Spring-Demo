package com.acidevil.springboot.demo.mvcbootdemo.service;

import java.util.List;

import com.acidevil.springboot.demo.mvcbootdemo.entity.Employee;

public interface EmployeeService {

	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	void save(Employee employee);
	
	void deleteById(int id);
}
