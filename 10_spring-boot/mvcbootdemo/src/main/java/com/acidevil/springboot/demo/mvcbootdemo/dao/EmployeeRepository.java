package com.acidevil.springboot.demo.mvcbootdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acidevil.springboot.demo.mvcbootdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// no need of code, all of the methods are auto magically served by spring data
	// JPA
}
