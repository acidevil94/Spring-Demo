package com.acidevil.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.acidevil.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			System.out.println("creating new student object");
			Student temp = new Student("Paul", "Wall", "paul@acidevil.com");

			System.out.println("beginning trnasaction");
			session.beginTransaction();

			System.out.println("saving the student");
			session.save(temp);

			System.out.println("committing");
			session.getTransaction().commit();
			
			
			System.out.println("Done");

		} catch (Exception exc) {
			factory.close();
		}
	}

}
