package com.acidevil.demo.one2many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.acidevil.demo.entity.one2many.Course;
import com.acidevil.demo.entity.one2many.Instructor;
import com.acidevil.demo.entity.one2many.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.one2many.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			Instructor instructor = new Instructor("Chad", "Darby", "darby@luv2code.com");

			InstructorDetail detail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!");

			Course course1 = new Course("Air gattair");
			Course course2 = new Course("Pinball master");
			instructor.setInstructorDetail(detail);
			
			instructor.add(course1);
			instructor.add(course2);
			

			System.out.println("beginning trnasaction");
			session.beginTransaction();

			session.save(instructor);
			session.save(course1);
			session.save(course2);

			System.out.println("committing");
			session.getTransaction().commit();

			System.out.println("Done");

		} catch (Exception exc) {

			session.close();
			factory.close();
		}
	}

}
