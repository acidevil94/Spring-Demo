package com.acidevil.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.acidevil.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			System.out.println("creating new student object");
			Student temp = new Student("Simone", "Wall", "sss@acidevil.com");

			System.out.println("beginning trnasaction");
			session.beginTransaction();

			System.out.println("saving the student");
			session.save(temp);
			
			System.out.println(temp);

			System.out.println("committing");
			session.getTransaction().commit();

			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			Student myStudent = session.get(Student.class,  temp.getId());
			
			
			System.out.println(myStudent);
			
			session.getTransaction().commit();
			
			System.out.println("Done");

		} catch (Exception exc) {
			factory.close();
		}

	}

}
