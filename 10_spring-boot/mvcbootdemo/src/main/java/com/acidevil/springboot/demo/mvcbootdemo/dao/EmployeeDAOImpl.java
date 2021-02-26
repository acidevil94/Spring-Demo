package com.acidevil.springboot.demo.mvcbootdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acidevil.springboot.demo.mvcbootdemo.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOImpl(EntityManager em) {
		this.entityManager = em;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		Session session = this.entityManager.unwrap(Session.class);
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		return query.getResultList();
	}

	@Override
	public Employee findById(int id) {
		Session session = this.entityManager.unwrap(Session.class);
		Employee employee = session.get(Employee.class, id);
		return employee;
	}

	@Override
	public void save(Employee employee) {
		Session session = this.entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int id) {
		Session session = this.entityManager.unwrap(Session.class);
		Query<?> query = session.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
	}

}
