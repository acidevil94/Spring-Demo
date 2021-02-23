package com.acidevil.demo.one2one.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.acidevil.demo.entity.one2one.uni.Instructor;
import com.acidevil.demo.entity.one2one.uni.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.one2one.uni.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			Instructor instructor = new Instructor("Chad", "Darby", "darby@luv2code.com");

			InstructorDetail detail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!");

			instructor.setInstructorDetail(detail);

			System.out.println("beginning trnasaction");
			session.beginTransaction();
			
			session.save(instructor);

			System.out.println("committing");
			session.getTransaction().commit();

			System.out.println("Done");

		} catch (Exception exc) {
			factory.close();
		}
	}

}
