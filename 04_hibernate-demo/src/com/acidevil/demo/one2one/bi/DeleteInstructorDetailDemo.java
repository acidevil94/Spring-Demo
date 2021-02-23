package com.acidevil.demo.one2one.bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.acidevil.demo.entity.one2one.bi.Instructor;
import com.acidevil.demo.entity.one2one.bi.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.one2one.uni.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			System.out.println("beginning trnasaction");
			session.beginTransaction();

			InstructorDetail detail = session.get(InstructorDetail.class, 2);

			session.delete(detail);

			System.out.println("committing");
			session.getTransaction().commit();

			System.out.println("Done");

		} catch (Exception exc) {
			session.close();
			factory.close();
		}
	}

}
