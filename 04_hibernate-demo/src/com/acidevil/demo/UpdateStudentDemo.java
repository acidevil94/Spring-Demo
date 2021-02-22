package com.acidevil.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.acidevil.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			System.out.println("beginning trnasaction");
			session.beginTransaction();

			Student myStudent = session.get(Student.class, 1);

			myStudent.setFirstName("Scooby");

			System.out.println("committing");
			session.getTransaction().commit();

			session = factory.getCurrentSession();
			session.beginTransaction();

			// update email for all students
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

			
			session.getTransaction().commit();
			System.out.println("Done");

		} catch (Exception exc) {
			factory.close();
		}

	}

}
