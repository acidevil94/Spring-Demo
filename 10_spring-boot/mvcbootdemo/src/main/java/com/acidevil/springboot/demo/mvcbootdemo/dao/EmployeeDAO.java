package com.acidevil.springboot.demo.mvcbootdemo.dao;

import java.util.List;

import com.acidevil.springboot.demo.mvcbootdemo.entity.Employee;

public interface EmployeeDAO {

	List<Employee> findAll();

	Employee findById(int id);

	void save(Employee employee);

	void deleteById(int id);
}
