package com.acidevil.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.acidevil.demo.entity.Student;

public class PrimaryKeyDemo {

	
	
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			System.out.println("creating new student object");
			Student temp1 = new Student("Paul", "Wall", "paul@acidevil.com");
			
			System.out.println("creating new student object");
			Student temp2 = new Student("Andrea", "Coluzzi", "col@acidevil.com");
			
			System.out.println("creating new student object");
			Student temp3 = new Student("John", "Doe", "doe@acidevil.com");

			System.out.println("beginning trnasaction");
			session.beginTransaction();

			System.out.println("saving the student");
			session.save(temp1);
			session.save(temp2);
			session.save(temp3);

			System.out.println("committing");
			session.getTransaction().commit();
			
			
			System.out.println("Done");

		} catch (Exception exc) {
			factory.close();
		}
	}
}
