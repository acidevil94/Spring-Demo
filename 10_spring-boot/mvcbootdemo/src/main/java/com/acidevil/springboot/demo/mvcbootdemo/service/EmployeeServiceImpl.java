package com.acidevil.springboot.demo.mvcbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.acidevil.springboot.demo.mvcbootdemo.dao.EmployeeDAO;
import com.acidevil.springboot.demo.mvcbootdemo.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO dao) {
		this.employeeDAO = dao;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return this.employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		return this.employeeDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		this.employeeDAO.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		this.employeeDAO.deleteById(id);
	}

}
