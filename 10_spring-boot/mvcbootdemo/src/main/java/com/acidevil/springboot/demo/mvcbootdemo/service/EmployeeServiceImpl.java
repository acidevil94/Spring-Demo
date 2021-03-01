package com.acidevil.springboot.demo.mvcbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acidevil.springboot.demo.mvcbootdemo.dao.EmployeeRepository;
import com.acidevil.springboot.demo.mvcbootdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

//	private Employee employeeDAO;

	private EmployeeRepository employeeDAO;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository dao) {
		this.employeeDAO = dao;
	}

	@Override
//	@Transactional		// spring data JPA is transactional
	public List<Employee> findAll() {
		return this.employeeDAO.findAll();
	}

//	@Override
//	@Transactional
//	public Employee findById(int id) {
//		return this.employeeDAO.findById(id);
//	}

	@Override
//	@Transactional
	public Employee findById(int id) {
		return this.employeeDAO.findById(id).orElseGet(null);
	}

	@Override
//	@Transactional
	public void save(Employee employee) {
		this.employeeDAO.save(employee);
	}

	@Override
//	@Transactional
	public void deleteById(int id) {
		this.employeeDAO.deleteById(id);
	}

}
