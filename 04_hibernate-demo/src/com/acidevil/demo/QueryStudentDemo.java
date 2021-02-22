package com.acidevil.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.acidevil.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			System.out.println("beginning trnasaction");
			session.beginTransaction();

			List<Student> students = session.createQuery("from Student").list();

			displayStudents(students);

			students = session.createQuery("from Student s where s.lastName='Doe'").list();

			displayStudents(students);

			students = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Simone'").list();

			displayStudents(students);

			System.out.println("committing");
			session.getTransaction().commit();

			System.out.println("Done");

		} catch (Exception exc) {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
	}

}
